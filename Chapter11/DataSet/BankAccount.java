//Chapter11 - Example 11.1

public class BankAccount implements Maximum
{
	private int accountNumber;
	private double balance;

	public BankAccount(double initialBalance)
	{
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
	
	public double getMax()
	{
	return balance;
	}
}