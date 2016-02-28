//Chapter 13 - Example 13.6

public class SavingAccount extends BankAccount
{
	private double interestRate;
	
	public SavingAccount (double rate)
	{
		interestRate = rate;
	}

	public void addInterest()
	{
		double interest = getBalance()*interestRate/100;
		deposit(interest);
	}
}