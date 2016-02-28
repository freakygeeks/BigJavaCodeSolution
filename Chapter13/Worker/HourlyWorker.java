//Chapter 13 - Exercise 13.6

public class HourlyWorker extends Worker
{
	private double pay;
	private int hour;
	
	public HourlyWorker (String n, double s)
	{
		super(n,s);
	}
	
	public double computePay (int h)
	{
		hour = h;
		if (hour > 40)
			{
				pay = (40 + ((hour - 40)*1.5))*salary_rate;
			}
		else
			{
				pay = hour*salary_rate;
			}
		
		return pay;
	}
	
	public String toString()
	{
		return super.toString() + hour + " hour is ";
	}
}