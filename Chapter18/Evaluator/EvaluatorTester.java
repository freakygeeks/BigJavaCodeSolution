//Chapter 18 - Example 18.5

import java.util.Scanner;

public class EvaluatorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an expression : ");
		String input = in.nextLine();
		
		Evaluator e = new Evaluator(input);
		int value = e.getExpressionValue();
		System.out.println(input + " = " + value);		
	}
}