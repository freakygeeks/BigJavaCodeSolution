//Chapter 6 - Exercise P6.13

public class NumMonth
{
	private int n;
	
	public NumMonth(int num)
	{
	n = num;
	}
	
	public String getDays()
	{
	String a = " ";
	
	if (n == 1)
		a = "31 days";
	else if (n == 2)
		a = "28 days";
	else if (n == 3)
		a = "31 days";
	else if (n == 4)
		a = "30 days";
	else if (n == 5)
		a = "31 days";
	else if (n == 6)
		a = "30 days";
	else if (n == 7)
		a = "31 days";
	else if (n == 8)
		a = "31 days";
	else if (n == 9)
		a = "30 days";
	else if (n == 10)
		a = "31 days";
	else if (n == 11 )
		a = "30 days";
	else if (n == 12)
		a = "31 days";
	else
		System.out.println ("Bad input!");
	
	return a;
	}
}
