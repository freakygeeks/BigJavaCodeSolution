//Chapter4
public class Operation
{
	public static final int PENNIES_PER_NICKEL = 5;
	public static final int PENNIES_PER_DIME = 10;
	public static final int PENNIES_PER_QUARTER = 25;
	public static final int PENNIES_PER_DOLLAR = 100;
	
	private double dollars;
	private double cents;
	
	public Operation()
	{
	dollars = 0;
	cents = 0;
	}
	
	public void addCalc(int dollars, int quarters, int nickel, int dimes, int pennies)
	{
	int total = (dollars*PENNIES_PER_DOLLAR) + (quarters*PENNIES_PER_QUARTER) + (nickel*PENNIES_PER_NICKEL) 
	+ (dimes*PENNIES_PER_DIME) + pennies;
	
	this.dollars = total/PENNIES_PER_DOLLAR;
	this.cents = total%PENNIES_PER_DOLLAR;
	}
	
	public double getDollars()
	{
	return this.dollars;
	}
	
	public double getCents()
	{
	return this.cents;
	}
}
	