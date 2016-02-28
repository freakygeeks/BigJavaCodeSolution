//Chapter 6 - Exercise P6.13

import java.util.Scanner;

public class NumMonthViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter month number : ");
	int month = in.nextInt();
	
	NumMonth calc = new NumMonth(month);
	System.out.println (calc.getDays());
	}
}