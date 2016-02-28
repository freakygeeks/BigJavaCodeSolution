//Chapter11 - Exercise P11.1

import java.util.Random;

public class Die implements Measure
{
	private Random gen;
	private int sides;
	int n;
	
	public Die ()
	{
	sides = 6;
	gen = new Random();
	cast();
	}
	
	public int cast()
	{
	n = 1 + gen.nextInt(sides);
	System.out.print (n + " " );
	return n;
	}
	
	public double getMax()
	{
	return n;
	}
}