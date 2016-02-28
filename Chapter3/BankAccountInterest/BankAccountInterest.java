//Chapter3 - Exercise P3.2
public class BankAccountInterest
{
	private double balance;
	
	public BankAccountInterest()
	{
	balance = 0;
	}
	
	public void saving (double amount)
	{
	double newSaving = this.balance + amount;
	this.balance = newSaving;
	}
	
	public void addInterest (double rate)
	{
	double newRate = ((this.balance*rate)/100) + this.balance;
	this.balance = newRate;
	}
	
	public double getBalance()
	{
	return this.balance;
	}
}