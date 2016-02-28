//Chapter 16 - Exercise CoinPurse

import java.io.Serializable;
import java.util.ArrayList;

public class Purse implements Serializable
{
	private ArrayList coins;
	
	public Purse()
	{
		coins = new ArrayList();
	}
	
	public void add(Coin aCoin)
	{
		coins.add(aCoin);
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