//Chapter3 - Example 3.5
public class BankAccountThis
{
	private double balance;
	
	public BankAccountThis()
	{
	balance =0;
	}
	
	public BankAccountThis(double initialBalance)
	{
	this.balance = initialBalance;
	}
	
	public void deposit(double amount)//mutator
	{
	double newBalance = this.balance + amount;
	this.balance = newBalance;
	}
	
	public void withdraw(double amount)//mutator
	{
	double newBalance = this.balance - amount;
	this.balance = newBalance;
	}
	
	public double getBalance()//assessor
	{
	return this.balance;
	}
}