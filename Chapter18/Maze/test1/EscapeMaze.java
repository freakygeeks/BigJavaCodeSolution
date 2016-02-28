public class EscapeMaze {
  public static void main(String[] args) {
    Maze maze = new Maze();
	/*System.out.println("Started of maze..");
    System.out.println(maze);
		System.out.println(maze.escape(4, 3));
		System.out.println("Expected : cannot escaped!");
		System.out.println(maze);
		System.out.println(maze.escape(5, 5));
		System.out.println("Expected : escape!");*/
    System.out.println(maze);
	if (maze.escape(11, 3))
      System.out.println("true");
    //if (maze.escape(5, 5))
     // System.out.println("false");
    else
      System.out.println("couldn't escape :-(");
    System.out.println(maze);
  }
}

class Maze {
  public static final char WALL = 'X';
  public static final char OPEN = ' ';
  public static final char BREADCRUMB = '.';
  
  private String[] board = new String[] {
	  
    "XXXXXXXXXXXXX",
    "X   X  XX   X",
    "  X X X XXX X",
    "X X X X X   X",
    "X X X     X X",
    "X X X X X X X",
    "X     X X X X",
    "XXXXXXXXXXXXX",
  };
  /*
    "XXXXXXXXXXXXX",
    "X   X  XX   X",
    "  X X X XXX X",
    "X X X X X   X",
    "X X X     X X",
    "X X X X X X X",
    "X     X X X X",
    "XXXXXXXXXXXXX",
  
  
	"* *******",
	"*     * *", 
	"* ***** *", 
	"* * *   *", 
	"* * *** *",
	"*   *   *",
	"*** * * *",
	"*     * *",
	"******* *",
	
	{* *******}, 
	{*     * *}, 
	{* ***** *}, 
	{* * *   *}, 
	{* * *** *}, 
	{*   *   *}, 
	{*** * * *}, 
	{*     * *}, 
	{******* *}
	*/
  public char getSquare(int x, int y) {
    return board[y].charAt(x);
  }
  
  public int getWidth() { return board[0].length(); }
  public int getHeight() { return board.length; }
  
  public void setSquare(int x, int y, char value) {
    board[y] = board[y].substring(0, x) + value + board[y].substring(x+1, getWidth());
  }
  
  public String toString() {
    String result = "";
    for (int i = 0; i < board.length; i++)
      result += board[i] + "\n";
    return result;
  }
  
  public boolean escape(int x, int y) {
    // base case
    if (getSquare(x, y) != OPEN)
      return false;
    
    else {
      setSquare(x, y, BREADCRUMB);

      // base case
      if (x == 0 || x == getWidth() - 1
      ||  y == 0 || y == getHeight() - 1)
        return true;
      
      return 
             escape(x-1, y) || escape(x+1, y) ||
             escape(x, y-1) || escape(x, y+1);
    }
  }
}