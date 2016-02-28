//Chapter 17 - Project 17.2

import java.util.Random;

public class RandomPlayer extends Player
{
	private Random gen;
	
	public RandomPlayer()
	{
		gen = new Random();
	}
	
	//get next move
	public Combination nextMove (Combination current)
	{
		while (true)
		{
			int i = gen.nextInt(3);
			int j = gen.nextInt(3);
			
			if (current.get(i, j) == Combination.EMPTY)
			{
				current.set(i, j, getMarker());
				return current;
			}
		}
	}
}