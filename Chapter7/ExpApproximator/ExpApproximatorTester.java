//Chapter7 - Exercise P7.14

import java.util.Scanner;

public class ExpApproximatorTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	System.out.println ("This program is use to calculate the sum of exponential power series given value of x");
	System.out.print ("Enter value of 'x' : ");
	double x = in.nextDouble();
	
	ExpApproximator calc = new ExpApproximator(x);
	calc.getPowSeries();	
	calc.getSum();
	System.out.println("Sum of e^" + x + ": " + calc.getSum());
	}
}