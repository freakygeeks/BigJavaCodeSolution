//Chapter 18 - Exercise P18.14
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_14
//https://www.cs.bu.edu/teaching/alg/maze/
//http://faculty.washington.edu/stepp/courses/2004autumn/tcss342/lectures/files/2004-10-28/EscapeMaze.java
//http://www.horstmann.com/sjsu/spring2012/cs46b/lab3/

public class Maze
{
	public static final char WALL = '*';
	public static final char OPEN = ' ';
	public static final char START = '.';
	
	private String[] board = new String[] {" "};
	
	public Maze(String[] b)
	{
		board = b;
	}
	
	public char getSquare (int x, int y)
	{
		return board[y].charAt(x);
	}
	
	public int getWidth()
	{
		return board[0].length();
	}
	
	public int getHeight()
	{
		return board.length;
	}
	
	public void setSquare (int x, int y, char value)
	{
		board[y] = board[y].substring(0, x) + value + board[y].substring(x+1, getWidth());
	}
	
	public String toString()
	{
		String result = "";
		
		for (int i = 0; i < board.length; i++)
		{
			result = result + board[i] + "\n";
		}
		
		return result;
	}
	
	public boolean escape (int x, int y)
	{
		if (getSquare(x, y) != OPEN)
		{
			return false;
		}
		
		else
		{
			setSquare(x, y, START);
			
			if (x == 0 || x == getWidth()-1 || y == 0 || y == getHeight()-1)
			{
				return true;
			}
			
			return escape(x-1, y) || escape(x+1,y) || escape(x, y-1) || escape(x, y+1);
		}
	}
}