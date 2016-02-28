//Chapter 23 - Example 23.3

public class BankAccountThreadTester
{
	public static void main (String[] args)
	{
		BankAccount account = new BankAccount();
		final double AMOUNT = 100;
		final int REPETITION = 1000;
		
		DepositRunnable d = new DepositRunnable(account, AMOUNT, REPETITION);
		WithdrawRunnable w = new WithdrawRunnable(account, AMOUNT, REPETITION);
		
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(w);
		
		t1.start();
		t2.start();
	}
}