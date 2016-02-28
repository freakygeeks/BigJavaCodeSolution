//Chapter4 - Exercise 4.17
import java.util.Scanner;

public class MonthNameTester
{
	public static void main (String[] args)
	{
	MonthName calc = new MonthName();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter the month number : ");
	int val = in.nextInt();
	
	calc.getMonth(val);
	
	System.out.println ("\n" + "Month number enter is : " + val);
	System.out.println ("Month name is : " + calc.getName());
	}
}