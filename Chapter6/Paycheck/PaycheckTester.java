//Chapter6 - Exercise P6.16

import java.util.Scanner;

public class PaycheckTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter name : ");
	String name = in.nextLine();
	
	System.out.print ("Enter working hours :");
	double hour = in.nextDouble();
	
	Paycheck calc = new Paycheck(name, hour);
	System.out.println ("\n" + calc.getName());
	System.out.println (calc.getWage());
	}
}