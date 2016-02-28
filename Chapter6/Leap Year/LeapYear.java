//Chapter 6 - Exercise P6.12

public class LeapYear
{
	private int y;
	
	public LeapYear(int year)
	{
	y = year;
	}
	
	public boolean isLeapYear()
	{
	boolean leap;
	
	int a = y%4;
	int b = y%100;
	int c = y%400;
	
	System.out.println ("y%4 = " + a);
	System.out.println ("y%100 = " + b);
	System.out.println ("y%400 = " + c);
	
	if (a == 0)
	{
		if (b != 0)
		{
			System.out.println ("This is a leap year " + y);
			return true;
		}
		else if (b == 0 && c == 0)
		{
			System.out.println ("This is a leap year " + y);
			return true;
		}
		else
			System.out.println ("Not a leap year " + y);
			return false;
	}	
	else 
		System.out.println ("Not a leap year " + y);
		return false;
	}
}