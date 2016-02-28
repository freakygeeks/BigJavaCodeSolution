//Chapter3 - Exercise P3.1
public class BankAccountAnother
{
	private double balance;
	
	public BankAccountAnother()
	{
	balance = 0;
	}
	
	public void deposit (double amount)
	{
	double deposit = this.balance + amount;
	this.balance = deposit;
	}
	
	public void withdraw (double amount)
	{
	double withdraw = this.balance - amount;
	this.balance = withdraw;
	}
	
	public double getBalance()
	{
	return this.balance;
	}
}