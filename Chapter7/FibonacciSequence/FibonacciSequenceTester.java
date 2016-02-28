//Chapter7 - Exercise P7.5

import java.util.Scanner;

public class FibonacciSequenceTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	FibonacciSequence calc = new FibonacciSequence();
	
	System.out.print ("Please enter the value of n : ");
	int input = in.nextInt();
	
	calc.getSeq(input);
	}
}