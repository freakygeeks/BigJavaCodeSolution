//Chapter 13 - Project 13.2

public class BankAccountMethod implements Cloneable
{
	private int accountNumber;
	private double balance;

	public BankAccountMethod(int anAccountNumber)
	{
	accountNumber = anAccountNumber;
	balance = 0;
	}
	
	public BankAccountMethod(int anAccountNumber, double initialBalance)
	{
	accountNumber = anAccountNumber;
	balance = initialBalance;
	}
	
	public int getAccountNumber()
	{
	return accountNumber;
	}
	
	public void deposit(double amount)
	{
	double newBalance = balance + amount;
	balance = newBalance;
	}
	
	public void withdraw(double amount)
	{
	double newBalance = balance - amount;
	balance = newBalance;
	}
	
	public double getBalance()
	{
	return balance;
	}
	
	public String toString()
	{
		return "Balance = $" + balance;
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}