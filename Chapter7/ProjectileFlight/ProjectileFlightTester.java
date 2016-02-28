//Chapter7 - Exercise P7.3 - http://horstmann.com/labrat/demo/ch6_programming.html

import java.util.Scanner;

public class ProjectileFlightTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	ProjectileFlight calc = new ProjectileFlight();
	
	System.out.print ("Please enter the initial velocity value : ");
	double input = in.nextDouble();
	calc.calcVelocity(input);
	
	System.out.println ("Total count is : " + calc.getCount());
	}
}