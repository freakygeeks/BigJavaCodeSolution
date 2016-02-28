//Chapter 13 - Exercise 13.8

public class SavingAccount extends BankAccount
{
	private double interestRate;
	
	public SavingAccount (double rate)
	{
		interestRate = rate;
	}
	
	public SavingAccount (double rate, double initialBalance)
	{
		super(initialBalance);
		interestRate = rate;
	}
	
	public void endOfMonth()
	{
		double interest = getBalance()*interestRate/100;
		super.deposit(interest);
	}
}