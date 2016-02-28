//Chapter 14 - Exercise 14.10

public class BankTextAreaPanel 
{

	private double balance;
	
	public BankTextAreaPanel()
	{

	}
	
	public void getDeposit(double amount)
	{
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	public void getInterest(double amount)
	{
		balance = balance - amount;
	}
	
	public double getBalance()
	{
		return balance;
	}
}