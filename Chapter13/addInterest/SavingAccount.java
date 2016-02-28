//Chapter 13 - Exercise 13.1

public class SavingAccount extends BankAccount
{
	private double interestRate;
	private double minimumBalance;
	
	public SavingAccount (double rate)
	{
		interestRate = rate;
		minimumBalance = 0;
	}
	
	public void addInterest()
	{
		double interest = minimumBalance*interestRate/100;
		super.deposit(interest);
		minimumBalance = super.getBalance();
	}
	
	public void withdraw (double amount)
	{
		super.withdraw(amount);
		if (super.getBalance() < minimumBalance)
			{
				minimumBalance = super.getBalance();
			}
	}
}