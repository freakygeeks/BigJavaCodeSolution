//Chapter10 - Example 10.1

import java.util.Scanner;

public class RootApproximatorTester
{
	public static void main (String[] args)
	{
	System.out.print ("Enter a number : ");
	Scanner in = new Scanner(System.in);
	double x = in.nextDouble();
	
	RootApproximator r = new RootApproximator(x);
	final int MAX_TRIES = 10;
	
	for (int tries = 1; tries <= MAX_TRIES; tries++)
		{
		double y = r.nextGuess();
		System.out.println ("Guess #" + tries + " : " + y);
		}	
	System.out.println ("Square root : " + r.getRoot());
	}
}