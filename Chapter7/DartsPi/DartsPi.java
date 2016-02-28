//Chapter7 - Exercise P7.16

import java.util.Random;

public class DartsPi
{
	private static final double RADIUS = 1;
	private static final double pointX = 0;
	private static final double pointY = 0;
	private Random gen;
	private double hit;
	private double tries;
	//private double n;
	private double x;
	private double y;
	private double aX;
	private double aY;
	private double low;
	private double high;
	
	DartsPi()
	{
	gen = new Random();
	hit = 0;
	tries = 0;
	//n = 10000;
	x = 0;
	y = 0;
	aX = 0;
	aY = 0;
	low = -1;
	high = 1;
	}
	
	public void getThrown()
	{
	//for (int i = 1; i <= n; i++)
		//{
		x = low + gen.nextDouble()*(high-low+1);
		aX = x;
		
		y = low + gen.nextDouble()*(high-low+1);
		aY = y;
		
		//System.out.println ("Random X : " + i + " is " + aX);
		//System.out.println ("Random Y : " + i + " is " + aY);
		
		double xMax = pointX + RADIUS;
		double xMin = pointX - RADIUS;
		double yMax = pointY + RADIUS;
		double yMin = pointY - RADIUS;
		
		tries++;
		if (xMin <= x && x <= xMax)
			{
			if (yMin <= y && y <= yMax)
				{
				hit++;
				//tries++;
				}
			}
		//}
	}
	
	/*public double getPi()
	{
	double Pi = n/hit;
	System.out.println (hit);
	System.out.println (tries);
	System.out.println ("Value of Pi is : " + Pi);
	return Pi;
	}*/
	
	public double getHit()
	{
	System.out.println (hit);
	return hit;
	}
	
	public double getTries()
	{
	System.out.println (tries);
	return tries;
	}
}
	