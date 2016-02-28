//Chapter7 - Exercise P7.12

import java.util.Scanner;

/**This program prints ten approximations for a square root.*/
public class HeronApproximatorTester
{  
	public static void main(String[] args)
	{  
	Scanner in = new Scanner(System.in);
	
	System.out.print("Enter a number: ");
	double x = in.nextDouble();
	HeronApproximator r = new HeronApproximator(x);
	
	final int MAX_TRIES = 10;
	for (int tries = 1; tries <= MAX_TRIES; tries++)
		{
		double y = r.nextGuess(); // return value of nextGuess() assessor method
		System.out.println("Guess #" + tries + ": " + y);// tries is the loop count, y is the xnew value
		}      
	System.out.println("Square root: " + r.getRoot());
	}
}