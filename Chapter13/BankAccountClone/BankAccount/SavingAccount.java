//Chapter 13 - Project 13.2

public class SavingAccount extends BankAccount implements Cloneable
{
	private double interestRate;
	
	public SavingAccount (double initialBalance)
	{
		super(initialBalance);
		interestRate = 0.5;
	}

	public void addInterest()
	{
		double interest = getBalance()*interestRate/100;
		deposit(interest);
	}
	
	public String toString()
	{
		return super.toString();
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}