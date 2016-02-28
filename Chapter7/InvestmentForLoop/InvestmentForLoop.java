//Chapter7 - Example 7.2

public class InvestmentForLoop
{
	private double balance;
	private double rate;
	private int years;
	
	public InvestmentForLoop(double aBalance, double aRate)
	{
	balance = aBalance;
	rate = aRate;
	years = 0;
	}
	
	public void waitForBalance (double targetBalance)
	{
	while (balance < targetBalance)
		{
		years++;
		double interest = balance*rate/100;
		balance = balance + interest;
		}
	}
	
	public void waitYears(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			double interest = balance*rate/100;
			balance = balance + interest;
		}
		years = years + n;
	}
	
	public double getBalance()
	{
	return balance;
	}
	
	public int getYears()
	{
	return years;
	}
}