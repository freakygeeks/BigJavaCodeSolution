//Chapter 17 - Project 17.2

import java.io.IOException;

public class TicTacToe
{
	private int player;
	private Combination current;
	
	public TicTacToe()
	{
		player = 0;
	}
	
	//play the game
	public void play (Player playerA, Player playerB) throws IOException
	{
		current = new Combination();
		int winner = Combination.EMPTY;
		
		playerA.setMarker(Combination.FILL_X);
		playerB.setMarker(Combination.FILL_O);
		
		do
		{
			if (player == 0)
			{
				current = playerA.nextMove(current);
			}
			
			else
			{
				current = playerB.nextMove(current);
			}
			
			player = 1 - player;
			showCombination();
			winner = current.getWinner();
		}
		
		while (winner == Combination.DRAW);
		
		if (winner == Combination.DRAW)
		{
			System.out.println("Draw.");
		}
		
		else
		{
			System.out.println (markerString(winner) + " won.");
		}
		
		playerA.gameOver(winner);
		playerB.gameOver(winner);
	}
	
	//show combination of moves
	public void showCombination()
	{
		System.out.println ("---");
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print (markerString(current.get(i,j)));
			}
			System.out.println();
		}
	}
	
	//mark the board
	public String markerString(int marker)
	{
		if (marker == Combination.FILL_X)
		{
			return "X";
		}
		
		else if (marker == Combination.FILL_O)
		{
			return "O";
		}
		
		else
		{
			return " ";
		}
	}
}


























