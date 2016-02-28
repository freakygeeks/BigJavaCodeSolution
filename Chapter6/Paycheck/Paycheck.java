//Chapter6 - Exercise P6.16

public class Paycheck
{
	private String name;
	private double hour;
	public static final double WAGE = 100;
	public static final double WAGE_OT = (WAGE*150/100);
	
	public Paycheck(String n, double h)
	{
	name = n;
	hour = h;
	}
	
	public String getName()
	{
	return name;
	}
	
	public double getWage()
	{
	double z = 0;
	double ot_hour = hour - 40;
	
	double normal_wage = hour*WAGE;
	double normal_wage_ot = 40*WAGE;
	double wage_ot = ot_hour*WAGE_OT;
		
	if (hour <= 40)
		z = normal_wage;
	else
		{
		z = normal_wage_ot + wage_ot;
		}
	return z;
	}
}