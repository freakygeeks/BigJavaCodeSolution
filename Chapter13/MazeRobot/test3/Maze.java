/** The Maze class creates a maze from 
 *  a String array and finds the path through the
 *  maze from the start S to the finish F.
 *  Non-navigable paths are denoted with an X.
 *  A space is navigable.
 */
public class Maze {
  private int[][] maze;            /* Our maze is maintained in an array
                                      of integers                     */ 
  private final char wall = 'X';   /* non-navigable walls in the maze */
  private final char finish = 'F'; /* the finish point in the maze */
  private final char start = 'S';  /* the starting point in the maze */
  private final int blocked = -1;  /* cannot move through wall position
                                      and show it as blocked */  
  private final int visited = -2;  /* we mark paths that are unsuccessful
                                      as "visited" to prevent trying to
                                      navigate them again. */
  private final int end = -3;      /* we need to mark the end with an
                                      integer to identify it.  We use -3 */  
  private int startRow;            /* Keep track of where to start - the row */ 
  private int startCol;            /*                            and the col */
  /* The following are used to control travel in the X and Y direction in the
   * array.  (This idea was proposed by student - A.R. Good thinking!) 
   * In addition, I have added the third array which gives a character that
   * illustrates the direction in which travel is proceeding. I have made
   * this static final so that it is defined only once for the class.  It
   * is constant - and does not change. */
  private static final int[] moveX = {0, 1, 0, -1};
  private static final int[] moveY = {-1, 0, 1, 0};
  private static final char[] dir = {'^','>','v','<'};

  /** Construct a maze using a String array.
   *  @param m the array of strings denoting the array.  Walls are 
   *  shown using an X, navigable positions are shown using a space, 
   *  the start is 'S', and the finish is 'F'.  The array must be
   *  a rectangle - ragged arrays will not work.  The array must also
   *  be larger than zero. */
  public Maze(String[] m) {
    if (m.length > 0) { 
      maze = new int[m.length] [m[0].length()];
      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[i].length(); j++) {
          if (m[i].charAt(j) == wall) {
            maze [i][j] = blocked;
          }
          if (m[i].charAt(j) == finish) {
            maze[i][j] = end;
          }
          if (m[i].charAt(j) == start) {
            startRow = i;
            startCol = j;
          }
        }
      }
    } else {
      throw new RuntimeException("Invalid Maze!");
    }
  }
  /** Print the maze.  Show the walls as 'X', show the visited positions
   *  as '.', the finish position as 'F'
   */ 
  public void printMaze() {
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (maze[i][j] == -1) {
          System.out.print('X');
        }
        if (maze[i][j] == -2) {
          System.out.print('.');
        }
        if (maze[i][j] == -3) {
          System.out.print('F');
        }
        if (maze[i][j] == 0) {
          System.out.print(' ');
        }
        if (maze[i][j] > 0) {
          System.out.print((char)maze[i][j]);
        }
      }
      System.out.print("\n");
    }
  }
  /** Determine if the maze is 'doable'.  That is, 
   *  can a path be found that goes from S to F 
   *  navigating through the spaces moving only one
   *  up or down, left or right. at a time.
   * @return true if a solution can be found, otherwise, return false.
   */
  public boolean canFinish() {
    return walkMaze(startRow, startCol, 'S') ;
  }
  
  // Here is some thinking we need to do before we code this:
  // 1) determine legal moves
  // 2) determine your termination condition.
  // 3) determine how to recurse (if necessary)
  // 4) determine how to block future travels through this step if false.
  /** Recursively walks the maze from the current position indicated 
   *  by row and col, to the finish.  Do not backtrack - revisit 
   *  paths that have already been visited.
   *  @param row the row of the next step in the maze.
   *  @param col the column of the next step in the maze.
   *  @param dir the direction of the next step in the maze.  This 
   *  is '^' for up, 'v' for down, '<' for left, and '>' for right.
   */
  public boolean walkMaze(int row, int col, char direction) {

    /* first determine whether the move is valid one.  If it is not,
     * return 'false' right away.   A move is not valid if the position
     * is out of the array bounds, is blocked, or has already been 
     * visited
     */
    if (row < 0  || row >= maze.length 
          || col < 0 || col >= maze[0].length
          || (maze[row][col] != 0 && maze[row][col] != end))
      return false;
    /*  If this position is the end, return true to indicate that 
     *  the maze has been successfully navigated.
     */
    if (maze[row][col] == end) return true;
    /* mark the maze with the direction in which you are now travelling */
    maze[row][col] = direction;
    /** Now try travelling from this point to any other point in the
     * maze.  We will use the arrays dirX and dirY in parallel to determine
     * our next row and column.  We must try walking up, right, down, and
     * left from this position.  We must see if going in a particular
     * direction yields a successful walk. We recursively call walkMaze with our
     * intended new step.  It recursively walks the maze until it either
     * is out-of-bounds, cannot go further, or arrives at 'F'.
     */
    int move = 0; // start at the beginning of the dirX dirY arrays
    boolean found = false; // initialized to not found 
    while (!found && move < moveX.length) { 
      found = walkMaze(row + moveY[move], col + moveX[move], dir[move]);
      move++;
    }
    /*  Don't try this position again if you
     *  cannot find a path through the maze from
     *  this point.  Mark this space as visited.
     *  This prevents backtracking.
     */
    if (!found) maze[row][col] = visited;
    return found;
  }
  /** The main method creates a maze using  
   *  a String array in Maze format.
   *  Just run main using the standard java Maze command.
   *  Or, you can create your own maze with a String array and 
   *  the maze constructor, and then walk it using the 
   *  canFinish() method.
   */ 
  public static void main(String [] args) {
    String [] myMaze = {
      "XXSXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
      "XX XXXXXXXXXXXXX     XXXXXXXXXXX",
      "XX    XXXXXXXXXX XXX XX     XXXX",
      "XXXXX  XXXXXX    XXX XX XXX XXXX",
      "XXX XX XXXXXX XX XXX XX  XX XXXX",
      "XXX     XXXXX XXXXXX XXXXXX XXXX",
      "XXXXXXX       XXXXXX        XXXX",
      "XXXXXXXXXX XXXXX XXXXXXXXXXXXXXX",
      "XXXXXXXXXX XX    XXXXX      XXXX",
      "XXXXXXXXXX    XXXXXXXX XXXX XXXX",
      "XXXXXXXXXXX XXXXXXXXXX XXXX XXXX",
      "XXXXXXXXXXX            XXXX XXXX",
      "XXXXXXXXXXXXXXXXXXXXXXXX XX XXXX",
      "XXXXXX              XXXX XX XXXX",
      "XXXXXX XXXXXXXXXXXX XX      XXXX",
      "XXXXXX XXF   XXXXXX XXXX XXXXXXX",
      "XXXXXX XXXXX   XXX            XX",
      "XXXXXX XXXXXXX XXXXXXXXXXX XXXXX",
      "XXXXXX XXXXXXX XXXXXXXXXXXXXXXXX",
      "XXXXXX            XXXXXXXXXXXXXX"};
    
      Maze m = new Maze(myMaze);
      if (m.maze[0][0] != 0) {
        System.out.println("this is not zero");
      }
      if (m.canFinish() ){  // call method to start maze walk.
        m.printMaze();
      } else {
        m.printMaze();
        System.out.println("No way to get there!");
      }
      
    }
  
}     
