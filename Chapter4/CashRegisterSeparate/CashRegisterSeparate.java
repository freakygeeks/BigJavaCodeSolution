//Chapter4 - Exercise P4.2
public class CashRegisterSeparate
{
	public static final double QUARTER_VALUE = 0.25;
	public static final double DIME_VALUE = 0.1;
	public static final double NICKEL_VALUE = 0.05;
	public static final double PENNY_VALUE = 0.01;
	
	private double purchase;
	private double dollar;
	private double quarter;
	private double dime;
	private double nickel;
	private double penny;
	private double count;
	
	public CashRegisterSeparate()
	{
	purchase = 0;
	dollar = 0;
	quarter = 0;
	dime = 0;
	nickel = 0;
	penny = 0;
	count = 0;
	}
	
	public void recordPurchase (double amount)
	{
	count++;
	this.purchase = this.purchase + amount;
	}
	
	public void enterDollar (double Dollar)
	{
	this.dollar = this.dollar + Dollar;
	}
	
	public void enterQuarter (double Quarter)
	{
	this.quarter = this.quarter + (Quarter*QUARTER_VALUE);
	}
	
	public void enterDime (double Dime)
	{
	this.dime = this.dime + (Dime*DIME_VALUE);
	}
	
	public void enterNickel (double Nickel)
	{
	this.nickel = this.nickel + (Nickel*NICKEL_VALUE);
	}
	
	public void enterPenny (double Penny)
	{
	this.penny = this.penny + (Penny*PENNY_VALUE);
	}
	
	public double getItemCount()
	{
	return this.count;
	}
	
	public void reset()
	{
	count = 0;
	}
	
	public double giveChange()
	{
	double change = dollar + quarter + dime + nickel + penny - purchase;
	dollar = 0;
	quarter = 0;
	dime = 0;
	nickel = 0;
	penny = 0;
	purchase = 0;
	return change;
	}
}