//Chapter11 - Example 11.1

public class CashRegister implements Maximum
{
	public static final double QUARTER_VALUE = 0.25;
	public static final double DIME_VALUE = 0.1;
	public static final double NICKEL_VALUE = 0.05;
	public static final double PENNY_VALUE = 0.01;
	
	private double purchase;
	private double payment;
	
	public CashRegister(double amount)
	{
	purchase =  amount;
	payment = 0;
	}
	
	public void recordPurchase (double amount)
	{
	this.purchase = this.purchase + amount;
	}
	
	public void enterPayment (int dollars, int quarters, int dimes, int nickels, int pennies)
	{
	this.payment = dollars + (quarters*QUARTER_VALUE) + (dimes*DIME_VALUE) + (nickels*NICKEL_VALUE) + (pennies*PENNY_VALUE);
	}
	
	public double giveChange()
	{
	double change = payment - purchase;
	purchase = 0;
	payment = 0;
	return change;
	}
	
	public double getMax()
	{
	return purchase;
	}
}