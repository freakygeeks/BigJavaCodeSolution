//Chapter7 - Example 7.5

import java.util.Random;

public class Die
{
	private Random gen;
	private int sides;
	
	public Die (int s)
	{
	sides = s;
	gen = new Random();
	}
	
	public int cast()
	{
	return 1 + gen.nextInt(sides);
	}
}