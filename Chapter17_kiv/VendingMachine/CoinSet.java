//Chapter 17 - Exercise 17.9

import java.util.ArrayList;

public class CoinSet
{
	private ArrayList set;
	
	public CoinSet()
	{
		set = new ArrayList();
	}
	
	//add a coin
	public void addCoin (Coin c)
	{
		set.add(c);
	}
	
	//add a set of coin
	public void addCoins (CoinSet other)
	{
		set.addAll(other.set);
	}
	
	public double getValue()
	{
		double total = 0;
		
		for (int i = 0; i < set.size(); i++)
		{
			Coin c = (Coin)set.get(i);
			total = total + c.getValue();
		}
		
		return total;
	}
	
	public void removeAllCoins()
	{
		set.clear();
	}
}












