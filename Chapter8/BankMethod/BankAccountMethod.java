//Chapter8 - Exercise P8.1

public class BankAccountMethod
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
}