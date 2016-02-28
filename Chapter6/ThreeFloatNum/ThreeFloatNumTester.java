//Chapter 6 -Exercise P6.4

import java.util.Scanner;

public class ThreeFloatNumTester
{
	public static void main (String[] args)
	{
	ThreeFloatNum calc = new ThreeFloatNum();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter three floating-point number");
	double a = in.nextDouble();
	double b = in.nextDouble();
	double c = in.nextDouble();
	
	calc.enterNumber(a,b,c);
	
	System.out.println ("The inputs in sorted order are");
	System.out.println (calc.getOrderLowest());
	System.out.println (calc.getOrderMiddle());
	System.out.println (calc.getOrderHighest());
	}
}
	
	