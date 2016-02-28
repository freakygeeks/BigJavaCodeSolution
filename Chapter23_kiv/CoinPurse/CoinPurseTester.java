//Chapter 23 - Exercise 23

public class CoinPurseTester
{
	private static double PENNY = 0.01;
	private static double NICKEL = 0.05;
	private static double DIME = 0.1;
	private static double QUARTER = 0.25;
	
	public static void main (String[] args)
	{
		Purse myPurse = new Purse();
		AddCoinThread addPennyThread = new AddCoinThread(myPurse, new Coin(PENNY, "penny"));
		AddCoinThread addQuarterThread = new AddCoinThread(myPurse, new Coin(QUARTER, "quarter"));
		RemoveCoinThread removeCoinThread = new RemoveCoinThread(myPurse);
		
		addPennyThread.start();
		addQuarterThread.start();
		removeCoinThread.start();
	}
}