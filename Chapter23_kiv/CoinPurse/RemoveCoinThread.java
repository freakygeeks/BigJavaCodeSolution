//Chapter 23 - Exercise 23

public class RemoveCoinThread extends Thread
{
	private Purse purse;
	private Coin coin;
	private static final int DELAY = 1000;
	
	public RemoveCoinThread (Purse aPurse)
	{
		purse = aPurse;
	}
	
	public void run()
	{
		try
		{
			while (true)
			{
				System.out.println("Remove " + purse.removeCoin().getName());
				sleep(DELAY);
			}
		}
		catch (InterruptedException exception)
		{
		}
	}
}