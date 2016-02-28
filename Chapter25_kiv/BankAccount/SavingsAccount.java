//Chapter 25 - Exercise 25.3

public class SavingsAccount extends BankAccount
{
	private double interestRate;
	
	public SavingsAccount (double rate)
	{
		interestRate = rate;
	}
	
	public void addInterest()
	{
		double interest = getBalance()*interestRate/100;
		deposit(interest);
	}
	
	public double getInterestRate()
	{
		return interestRate;
	}
}













