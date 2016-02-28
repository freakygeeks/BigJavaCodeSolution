//Chapter7 - Exercise P7.4

import java.util.Scanner;

public class CannonBallTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	CannonBall calc = new CannonBall();
	
	System.out.print ("Please enter the initial velocity value : ");
	double velocity = in.nextDouble();
	
	System.out.print ("Please enter the starting angle : ");
	double angle = in.nextDouble();
	
	calc.calcVelocity(velocity, angle);
	
	System.out.println ("Total count is : " + calc.getCount());
	}
}