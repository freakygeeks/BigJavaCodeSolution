//Chapter 15 - Exercise 15.1

public class BankAccount
{
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	public BankAccount (double initialBalance)
	{
		if (initialBalance < 0) throw new IllegalArgumentException ("Cannot enter " +
			"negative balance");
			
		balance = initialBalance;
	}
	
	public void deposit (double amount)
	{
		if (amount < 0) throw new IllegalArgumentException ("Cannot enter " +
			"negative amount");
			
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	public void withdraw (double amount)
	{
		if (amount < 0 || amount > balance) throw new IllegalArgumentException ("Cannot enter " +
			"this amount");
			
		double newBalance = balance - amount;
		balance = newBalance;
	}
	
	public double getBalance()
	{
		return balance;
	}
}











































