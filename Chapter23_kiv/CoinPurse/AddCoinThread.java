//Chapter 23 - Exercise 23

public class AddCoinThread extends Thread
{
	private Purse purse;
	private Coin coin;
	private static final int DELAY = 1000;
	
	public AddCoinThread (Purse aPurse, Coin aCoin)
	{
		purse = aPurse;
		coin = aCoin;
	}
	
	public void run()
	{
		try
		{
			while (true)
			{
				System.out.println("Add " + coin.getName());
				purse.addCoin(coin);
				sleep(DELAY);
			}
		}
		
		catch (InterruptedException exception)
		{
		}
	}
}