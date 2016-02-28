//Chapter 21 - Exercise 21.7

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
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	public void withdraw (double amount)
	{
		double newBalance = balance - amount;
		balance = newBalance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public boolean equals (Object otherObject)
	{
		if (otherObject == null)
		{
			return false;
		}
		
		if (getClass() != otherObject.getClass())
		{
			return false;
		}
		
		BankAccount other = (BankAccount)otherObject;
		return balance == other.balance;
	}
	
	public int hashCode()
	{
		return new Double(balance).hashCode();
	}
	
	public String toString()
	{
		return "BankAccount [balance = " + balance + "]";
	}
}




















