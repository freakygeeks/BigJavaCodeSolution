//Chapter7 - Exercise P7.13

import java.util.Scanner;

public class NewtonRaphsonApproximatorTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	System.out.print ("Enter nth root number, n : ");
	double n = in.nextDouble(); 
	
	System.out.print ("Enter floating point number, x : ");
	double x = in.nextDouble(); 
	
	NewtonRaphsonApproximator calc = new NewtonRaphsonApproximator(n, x);
	calc.getGuess();
	calc.getRoot();
	}
}