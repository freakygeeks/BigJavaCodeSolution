//Chapter 17 - Exercise 17.5

public class Player
{
	private String name;
	private int score;
	private int level;
	
	public Player()
	{
		name  = "";
		score = 0;
		level = 1;
	}
	
	public Player (String playerName, int initialLevel)
	{
		name = playerName;
		score = 0;
		level = initialLevel;
	}
	
	public void incrementScore()
	{
		score++;
		if (score % 5 == 0 && level < 4)
		{
			level++;
		}
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public String getName()
	{
		return name;
	}
}