//Chapter 17 - Project 17.2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TictacToeTester
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		boolean more = true;
		
		TicTacToe game = new TicTacToe();
		SmartPlayer smart = new SmartPlayer();
		HumanPlayer human = new HumanPlayer(console);
		
		while(more)
		{
			System.out.println ("T)rain P)lay Q)uit");
			String command = console.readLine().toUpperCase();
			
			if (command.equals("T"))
			{
				RandomPlayer dumb = new RandomPlayer();
				System.out.println ("How many round?");
				String input = console.readLine();
				int rounds = Integer.parseInt(input);
				
				for (int i = 0; i < rounds; i++)
				{
					game.play(dumb, smart);
				}
			}
			
			else if (command.equals("P"))
			{
				game.play(human, smart);
			}
			
			else if (command.equals("Q"))
			{
				more = false;
			}
		}
	}
}































