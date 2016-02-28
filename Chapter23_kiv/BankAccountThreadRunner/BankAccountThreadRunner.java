//Chapter 23 - Example 23.5

public class BankAccountThreadRunner
{
	public static void main (String[] args)
	{
		BankAccount account = new BankAccount();
		final double AMOUNT = 100;
		final int REPETITION = 100;
		final int THREAD = 100;
		
		for (int i = 1; i <= THREAD; i++)
		{
			DepositRunnable d = new DepositRunnable(account, AMOUNT, REPETITION);
			WithdrawRunnable w = new WithdrawRunnable(account, AMOUNT, REPETITION);
			
			Thread dt = new Thread(d);
			Thread wt = new Thread(w);
			
			dt.start();
			wt.start();
		}
	}
}