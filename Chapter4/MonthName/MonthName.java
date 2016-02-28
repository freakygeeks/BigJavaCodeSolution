//Chapter4 - Exercise 4.17
public class MonthName
{
	private int month;
	
	public MonthName()
	{
	month = 0;
	}
	
	public void getMonth(int digit)
	{
	this.month = this.month + digit;
	}
	
	public String getName()
	{
	if ((month<1)||(month>12))
	{
		System.err.println ("Error - invalid month digit : " + month);
		return " ";
	}
	
	String monthName = "January   Febuary   March     April     May       June      July      August    September October   November  December  ";
	int startIndex = (int)((month-1)*10);
	int endIndex = (int)(startIndex+10);
	
	return monthName.substring(startIndex,endIndex);
	}
}