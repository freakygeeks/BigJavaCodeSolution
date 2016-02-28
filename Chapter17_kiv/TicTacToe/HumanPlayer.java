//Chapter 17 - Project 17.2

import java.io.BufferedReader;
import java.io.IOException;

public class HumanPlayer extends Player
{
	private BufferedReader console;
	
	public HumanPlayer(BufferedReader c)
	{
		console = c;
	}
	
	//get next move
	public Combination nextMove (Combination current) throws IOException
	{
		while (true)
		{
			System.out.println ("Enter row (1-3)");
			String input = console.readLine();
			int i = Integer.parseInt(input);
			
			System.out.println ("Enter column (1-3)");
			input = console.readLine();
			int j = Integer.parseInt(input);
			
			if (1 <= i && i <= 3 && 1 <= j && j<= 3 && current.get(i-1, j-1) == Combination.EMPTY)
			{
				current.set(i-1, j-1, getMarker());
				return current;
			}
		}
	}
}






































