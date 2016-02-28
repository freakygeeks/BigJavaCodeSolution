//Chapter 17 - Project 17.2

import java.io.IOException;

public abstract class Player
{
	private int marker;
	
	public void setMarker(int m)
	{
		marker = m;
	}
	
	public int getMarker()
	{
		return marker;
	}
	
	public void gameOver (int winner)
	{
	}
	
	public abstract Combination nextMove (Combination current) throws IOException;
}