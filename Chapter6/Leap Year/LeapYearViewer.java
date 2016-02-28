//Chapter 6 - Exercise P6.12

import java.util.Scanner;

public class LeapYearViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.println("Enter year : ");
	int y = in.nextInt();
	
	LeapYear calc = new LeapYear(y);
	System.out.println (calc.isLeapYear());
	}
}