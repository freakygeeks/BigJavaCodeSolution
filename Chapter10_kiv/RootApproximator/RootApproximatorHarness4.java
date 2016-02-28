//Chapter10 - Example Advanced Topic 10.1

import java.util.Scanner;

public class RootApproximatorHarness4 //test harness to get square root by getting input number using file test.in and output to file test.out
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	boolean done = false;
	
	while (in.hasNextDouble())
		{
		double x = in.nextDouble();
		RootApproximator r = new RootApproximator(x);
		
		double y = r.getRoot();
		System.out.println ("Square root of " + x + " = " + y);
		}
	}
}