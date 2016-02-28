//Chapter7 - Example 7.5

import java.util.Random;

public class Needle
{
	private Random gen;
	private int hit;
	private int tries;
	
	public Needle()
	{
	gen = new Random();
	hit = 0;
	tries = 0;
	}
	
	public void drop()
	{
	double yLow = 2*gen.nextDouble();
	double angle = 180*gen.nextDouble();
	double yHigh = yLow+Math.sin(Math.toRadians(angle));
	if (yHigh >= 2)
		hit++;
		tries++;
	}
	
	public int getHit()
	{
	System.out.println (hit);
	return hit;
	}
	
	public int getTry()
	{
	System.out.println (tries);
	return tries;
	}
}