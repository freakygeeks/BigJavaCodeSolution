//Chapter7 - Example 7.1

public class InvestmentWhileLoop
{
	private double balance;
	private double rate;
	private int years;
	
	public InvestmentWhileLoop (double aBalance, double aRate)
	{
	balance = aBalance;
	rate = aRate;
	years = 0;
	}
	
	public void waitForBalance ()//(double targetBalance)
	{
	//while (balance < targetBalance)
	while (balance < 20000)
		{
		years++;
		double interest = balance*rate/100;
		balance = balance + interest;
		}
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