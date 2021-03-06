//Chapter10 - Example 10.3

import java.util.Random;

public class RootApproximatorHarness5 //test harness to get square root by generating a random number using 100 sample and check the output value is correct
{
	public static void main (String[] args)
	{
	final double SAMPLES = 100;
	int passcount = 0;
	int failcount = 0;
	Random generator = new Random();
	for (int i = 1; i <= SAMPLES; i++)
		{
		double x = 1000*generator.nextDouble();
		RootApproximator r = new RootApproximator(x);
		
		double y = r.getRoot();
				
		if (Numeric.approxEqual(y*y, x))
			{
			System.out.print ("Test passed : " );
			passcount++;
			}
		else
			{
			System.out.print ("Test failed : ");
			failcount++;
			}
		System.out.println ("x = " + x + " , root squared = " + y*y);
		}
	System.out.println ("Pass : " + passcount);
	System.out.println ("Fail : " + failcount);
	}
}