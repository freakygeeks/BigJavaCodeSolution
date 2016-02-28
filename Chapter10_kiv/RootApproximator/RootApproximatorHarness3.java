//Chapter10 - Example 10.2

import java.util.Random;

public class RootApproximatorHarness3 //test harness to get square root by generating a random number of 100 samples
{
	public static void main (String[] args)
	{
	final double SAMPLES = 100;
	Random generator = new Random();
	for (int i = 1; i <= SAMPLES; i++)
		{
		double x = 1000*generator.nextDouble();
		RootApproximator r = new RootApproximator(x);
		
		double y = r.getRoot();
		System.out.println ("Square root of " + x + " = " + y);
		}
	}
}