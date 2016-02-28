//Chapter 17 - Project 17.2

public class Combination
{
	public static final int EMPTY = 0;
	public static final int FILL_X = 1;
	public static final int FILL_O = 2;
	public static final int DRAW = 3;
	
	private int[][] positions;
	
	public Combination()
	{
		positions = new int[3][3];
	}
	
	//determine if position is equals
	public boolean equals (Object other)
	{
		if (other == null)
		{
			return false;
		}
		
		Combination b = (Combination) other;
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (positions[i][j] != b.positions[i][j])
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	//return an object
	public Object clone()
	{
		Combination r = new Combination();
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				r.positions[i][j] = positions[i][j];
			}
		}
		
		return r;
	}
	
	//get the position
	public int get (int i, int j)
	{
		return positions[i][j];
	}
	
	//set the position
	public void set(int i, int j, int value)
	{
		positions[i][j] = value;
	}
	
	//get the winner
	public int getWinner()
	{
		for (int i = 0; i < 3; i++)
		{
			if (positions[i][0] == positions[i][1] && positions[i][1] == positions[i][2])
			{
				return positions[i][0];
			}
			
			if (positions[0][i] == positions[1][i] && positions[1][i] == positions[2][i])
			{
				return positions[0][i];
			}
		}
		
		if (positions[0][0] == positions[1][1] && positions[1][1] == positions[2][2])
		{
			return positions[0][0];
		}
		
		if (positions[0][2] == positions[1][1] && positions[1][1] == positions[2][0])
		{
			return positions[2][0];
		}
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (positions[i][j] == EMPTY)
				{
					return EMPTY;
				}
			}
		}
		
		return DRAW;
	}
	
	//string representation of tictactoe board
	public String toString()
	{
		String r = "[";
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				r += positions[i][j] == 0 ? "." : positions[i][j] == FILL_X ? "X" : "O";
			}
			r += (i<2) ? "|" : "]";
		}
		
		return r;
	}
}













