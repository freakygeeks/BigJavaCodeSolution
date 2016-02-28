//Chapter8 - Project P8.2

//http://math.hws.edu/javanotes/c7/s5.html
//http://www.math.com/students/wonders/life/life.html
//http://www.bitstorm.org/gameoflife/code/
//http://www.brian-borowski.com/software/life/

public class GameOfLife
{
	public static void show(boolean[][] grid) //to create the output of cell
	{
        String s = "";
        for(boolean[] row : grid)
		{
            for(boolean val : row)
                if(val)
                    s += "*"; //live cell
                else
                    s += ".";//dead cell
            s += "\n";//s = s + "\n"
        }
        System.out.println(s); //print the output
    }
    
    public static boolean[][] gen() //for random output at starting of simulation
	{
        boolean[][] grid = new boolean[10][10]; 
        for(int r = 0; r < 10; r++) //for row
            for(int c = 0; c < 10; c++) //for column
                if( Math.random() > 0.7 ) 
                    grid[r][c] = true;
        return grid;
    }
	
	public static boolean[][] nextGen(boolean[][] world) //for random output after the start of simulation
	{
        boolean[][] newWorld = new boolean[world.length][world[0].length];
        int num;
        for(int r = 0; r < world.length; r++) //for row
		{
            for(int c = 0; c < world[0].length; c++) //for column
			{
                num = numNeighbors(world, r, c);
                if( occupiedNext(num, world[r][c]) ) //if occupied
                    newWorld[r][c] = true;
            }
        }
        return newWorld;
    }
    
    public static boolean occupiedNext(int numNeighbors, boolean occupied) //if cell is occupied 
	{
        if( occupied && (numNeighbors == 2 || numNeighbors == 3)) //if neighbor is two or three, cell will live
            return true;
        else if (!occupied && numNeighbors == 3) // if neighbor is three, cell will live
            return true;
        else //otherwise cell will dead
            return false;
    }

    private static int numNeighbors(boolean[][] world, int row, int col) //for neighbor
	{
        int num = world[row][col] ? -1 : 0;
        for(int r = row - 1; r <= row + 1; r++)
            for(int c = col - 1; c <= col + 1; c++)
                if( inbounds(world, r, c) && world[r][c] )
                    num++;

        return num;
    }

    private static boolean inbounds(boolean[][] world, int r, int c) 
	{
        return r >= 0 && r < world.length && c >= 0 &&
        c < world[0].length;
    }
}