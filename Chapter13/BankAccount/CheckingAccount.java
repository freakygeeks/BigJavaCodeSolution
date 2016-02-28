//Chapter 13 - Example 13.6

public class CheckingAccount extends BankAccount
{
	private int transactionCount;
	private static final int FREE_TRANSACTION = 3;
	private static final double TRANSACTION_FEE = 2.0;
	
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
		if (transactionCount > FREE_TRANSACTION)
			{
				double fee = TRANSACTION_FEE*(transactionCount - FREE_TRANSACTION);
				super.withdraw(fee);
			}
		transactionCount++;
	}
}