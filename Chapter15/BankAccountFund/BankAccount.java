//Chapter 15 - Exercise 15.5


public class BankAccount
{
	private double balance;
	
	public BankAccount() //throws BadDataException
	{
		balance = 0;
	}
	
	public BankAccount (double initialBalance) throws BadDataException
	{
		if (initialBalance < 0) throw new BadDataException ("Cannot enter negative balance");
		
		balance = initialBalance;
	}
	
	public void deposit (double amount) throws BadDataException
	{
		if (amount < 0) throw new BadDataException ("Cannot enter negative amount");
		
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	public void withdraw (double amount) throws InsufficientFundsException
	{
		if (amount < 0 || amount > balance) throw new InsufficientFundsException ("Cannot enter this amount");
		
		double newBalance = balance - amount;
		balance = newBalance;
	}
	
	public double getBalance()
	{
		return balance;
	}
}

