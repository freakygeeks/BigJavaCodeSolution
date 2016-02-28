//Chapter3 - Exercise P3.3
public class SavingAccount
{
	private double balance;
	
	public SavingAccount()
	{
	balance = 1000;
	}
	
	public void addSaving (double amount)
	{
	double newSaving = this.balance + amount;
	this.balance = newSaving;
	}
	
	public void interest (double rate)
	{
	double newInterest = ((this.balance*rate)/100) + this.balance;
	this.balance = newInterest;
	}
	
	public void addInterest ()
	{
	this.interest(10);
	}

	public double getBalance()
	{
	return this.balance;
	}
}
	