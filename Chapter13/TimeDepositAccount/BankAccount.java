//Chapter 13 - Exercise 13.2
//http://www.cs.dartmouth.edu/~cs5/lectures/0429/0429.html

public class BankAccount
{
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	public BankAccount (double initialBalance)
	{
		balance = initialBalance;
	}

	public void deposit (double amount)
	{
		balance = balance + amount;
	}
	
	public void withdraw (double amount)
	{
		balance = balance - amount;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void transfer (double amount, BankAccount other)
	{
		withdraw (amount);
		other.deposit(amount);
	}
	
	public String toString()
	{
		return "Account balance : " + balance;
	}
}