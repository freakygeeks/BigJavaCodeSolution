//Chapter 13 - Exercise 13.2

import java.util.Date;

public class TimeDepositAccount extends SavingAccount
{
	private int elapsedPeriods;
	private int maturityPeriods;
	private double interestPenaltyRate;
	
	public TimeDepositAccount(double rate, double initialBalance, int maturity, double penalty)
	{
		super(rate, initialBalance);
		elapsedPeriods = 0;
		maturityPeriods = maturity;
		interestPenaltyRate = penalty;
	}
	
	public void addInterest()
	{
		elapsedPeriods++;
		super.addInterest();
	}
	
	public void withdraw (double amount)
	{
		if (elapsedPeriods < maturityPeriods)
			{
				super.withdraw((interestPenaltyRate/100)*elapsedPeriods*getBalance());
				super.withdraw(amount);
			}
	}
}