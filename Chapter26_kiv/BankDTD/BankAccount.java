//Chapter 26 - Exercise 26.5

public class BankAccount
{
	private int ano;
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	public BankAccount (int aNumber, double initialBalance)
	{
		ano = aNumber;
		balance = initialBalance;
	}
	
	public double getBalance()
	{
		return balance;
	}
}