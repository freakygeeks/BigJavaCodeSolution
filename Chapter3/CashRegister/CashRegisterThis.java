//Chapter3
public class CashRegisterThis
{
	private double change;
	
	public CashRegisterThis()
	{
	change = 0;
	}
	
	public void enterPayment(double amount)//mutator
	{
	double payment = this.change + amount;
	this.change = payment;
	}
	
	public void recordPurchase(double amount)//mutator
	{
	double purchase = this.change - amount;
	this.change = purchase;
	}
	
	public double getChange()//assessor
	{
	return this.change;
	}
}
	

	