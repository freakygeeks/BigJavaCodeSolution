//Chapter4 - Exercise 4.14
import java.util.Scanner;

public class TimeIntervalTester
{
	public static void main (String[] args)
	{
	TimeInterval calc = new TimeInterval();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter the first time value : ");
	int first = in.nextInt();
	
	System.out.println ("Please enter the second time value : ");
	int second = in.nextInt();
	
	calc.addTime(first,second);
	
	System.out.println ("The total hours of first time value is : " + calc.getHourFirst());
	System.out.println ("The total hours of second time value is : " + calc.getHourSecond());
	System.out.println ("The hour interval between first and second time is : " + calc.getHour() + " hours");
	System.out.println ("The minute interval between first and second time is : " + calc.getMinute() + " minutes");
	}
}