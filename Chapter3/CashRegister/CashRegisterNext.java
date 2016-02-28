//Chapter3
public class CashRegisterNext
{
	private double payment;
	private double purchase;
	private double change;
	
	public CashRegisterNext()
	{
	payment = 0;
	purchase =0;
	//change = 0;
	}
	
	public void enterPayment(double amount)//mutator
	{
	double newPayment = this.payment + amount;
	this.payment = newPayment;
	}
	
	public void recordPurchase(double amount)//mutator
	{
	double newPurchase = this.purchase + amount;
	this.purchase = newPurchase;
	}
	
	public double getChange()//assessor
	{
	double change = this.payment - this.purchase;
	return this.change;
	}
}
	

	