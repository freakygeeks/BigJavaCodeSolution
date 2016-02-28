//Chapter4 - Exercise 4.13

import java.util.Scanner;

public class QuadraticEquationTester
{
	public static void main (String[] args)
	{
	QuadraticEquation calc = new QuadraticEquation();
	Scanner in = new Scanner(System.in);
	
	System.out.println("Please enter the first coefficients value 'a' : ");
	double a = in.nextDouble();
	
	System.out.println("Please enter the second coefficients value 'b' : ");
	double b = in.nextDouble();
	
	System.out.println("Please enter the third coefficients value 'c' : " );
	double c = in.nextDouble();
	
	calc.getValue(a,b,c);
	
	System.out.println("The first solution value is : " + calc.getSolutionOne());
	System.out.println("The second solution value is : " + calc.getSolutionTwo());
	}
}