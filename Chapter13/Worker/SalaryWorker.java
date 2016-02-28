//Chapter 13 - Exercise 13.6

public class SalaryWorker extends Worker
{
	private double pay;
	private int hour;
	
	public SalaryWorker (String n, double s)
	{
		super(n,s);
	}
	
	public double computePay (int h)
	{
		hour = h;
		pay = 40*salary_rate;
		
		return pay;
	}
	
	public String toString()
	{
		return super.toString() + hour + " hour is ";
	}
}