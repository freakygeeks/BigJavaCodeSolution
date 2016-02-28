//Chapter 13 - Exercise 13.1

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
	
	public void transfer (double amount, BankAccount other) //to create another object for BankAccount
	{
		withdraw(amount);
		other.deposit(amount);
	}	
}