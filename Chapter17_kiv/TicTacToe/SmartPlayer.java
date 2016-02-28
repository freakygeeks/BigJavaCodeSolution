//Chapter 17 - Project 17.2

import java.util.ArrayList;
import java.util.Random;

public class SmartPlayer extends RandomPlayer
{
	private Combination previous;
	private ArrayList losers;
	private Random gen;
	
	public SmartPlayer()
	{
		losers = new ArrayList();
		previous = null;
		gen = new Random();
	}
	
	//get next move
	public Combination nextMove (Combination current)
	{
		ArrayList nextMoves = new ArrayList();
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (current.get(i, j) == Combination.EMPTY)
				{
					Combination c = (Combination)current.clone();
					c.set(i, j, getMarker());
					
					if (!isLoser(c))
					{
						nextMoves.add(c);
					}
				}
			}
		}
		
		if (nextMoves.size() == 0)
		{
			losers.add(previous);
			return super.nextMove(current);
		}
		
		else
		{
			int i = gen.nextInt(nextMoves.size());
			Combination c = (Combination)nextMoves.get(i);
			previous = (Combination)c.clone();
			return c;
		}
	}
	
	//determine if game is over
	public void gameOver (int winner)
	{
		if (winner != Combination.DRAW && winner != getMarker())
		{
			losers.add(previous);
		}
		
		previous = null;
	}
	
	//determine if a player is a loser
	private boolean isLoser(Combination c)
	{
		for (int i = 0; i < losers.size(); i++)
		{
			if (c.equals(losers.get(i)))
			{
				return true;
			}
		}
		
		return false;
	}
}


















