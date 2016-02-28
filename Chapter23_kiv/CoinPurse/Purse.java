//Chapter 23 - Exercise 23

import java.util.ArrayList;

public class Purse
{
	private ArrayList coins;
	
	public Purse()
	{
		coins = new ArrayList();
	}
	
	public synchronized void addCoin (Coin aCoin) throws InterruptedException
	{
		coins.add(aCoin);
		notifyAll();
	}
	
	public synchronized Coin removeCoin() throws InterruptedException
	{
		while (coins.isEmpty())
		{
			wait();
		}
		
		return (Coin)coins.remove(0);
	}
	
	public double getTotal()
	{
		double total = 0;
		
		for (int i = 0; i < coins.size(); i++)
		{
			Coin aCoin = (Coin)coins.get(i);
			total = total + aCoin.getValue();
		}
		
		return total;
	}
}






















