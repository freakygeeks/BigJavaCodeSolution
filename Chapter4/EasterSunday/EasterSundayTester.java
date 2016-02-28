//Chapter4 - Exercise 4.18
import java.util.Scanner;

public class EasterSundayTester
{
	public static void main (String[] args)
	{
	EasterSunday calc = new EasterSunday();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter year digit to calculate for Easter Sunday date : ");
	int year = in.nextInt();
	
	calc.getYear(year);
	
	System.out.println ("\n" + "The Easter Sunday year is : " + calc.getEasterSunday());
	System.out.println ("The Easter Sunday month is : " + calc.getEasterSundayMonth()); 
	System.out.println ("The Easter Sunday date is : " + calc.getEasterSundayDay());
	}
}