//Chapter 13 - Exercise 13.8

public class CheckingAccount extends BankAccount
{
	private int count;
	private static final int FREE = 3;
	private static final double FEE = 0.50;
	
	public CheckingAccount()
	{
		count = 0;
	}
	
	public CheckingAccount (double initialBalance)
	{
		super(initialBalance);
		count = 0;
	}
	
	public void deposit (double amount)
	{
		count++;
		super.deposit(amount);
	}
	
	public void withdraw (double amount)
	{
		count++;
		super.withdraw(amount);
	}
	
	public void endOfMonth()
	{
		if (count > FEE)
			{
				double fee = FEE*(count-FREE);
				super.withdraw(fee);
			}
		count = 0;
	}	
}