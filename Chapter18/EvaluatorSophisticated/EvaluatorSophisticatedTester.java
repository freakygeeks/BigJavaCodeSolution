//Chapter 18 - Project 18.1

import java.util.Scanner;

public class EvaluatorSophisticatedTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an expression : ");
		String input = in.nextLine();
		
		EvaluatorSophisticated e = new EvaluatorSophisticated(input);
		int value = e.getExpressionValue();
		System.out.println(input + " = " + value);		
	}
}