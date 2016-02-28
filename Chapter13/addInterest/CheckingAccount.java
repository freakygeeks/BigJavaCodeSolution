//Chapter 13 - Exercise 13.1

public class CheckingAccount extends BankAccount
{
	private int transactionCount;
	private static final int FREE = 3;
	private static final double FEE = 2.0;
	
	public CheckingAccount (double initialBalance)
	{
		super(initialBalance);
		transactionCount = 0;
	}
	
	public void deposit (double amount)
	{
		transactionCount++;
		super.deposit(amount);
	}
	
	public void withdraw (double amount)
	{
		transactionCount++;
		super.withdraw(amount);
	}
	
	public void deductFee()
	{
		if (transactionCount > FEE)
			{
				double fee = FEE*(transactionCount - FREE);
				super.withdraw(fee);
			}
	}
}