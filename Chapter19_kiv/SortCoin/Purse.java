//Chapter 19 - Exercise 19.7

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Purse
{
	private ArrayList coin;
	
	public Purse()
	{
		coin = new ArrayList();
	}
	
	//add coin to the purse
	public void add (Coin aCoin)
	{
		coin.add(aCoin);
	}
	
	//return string describing the purse contents sorted by most valuable coin value
	public String toString()
	{
		class CoinComparator implements Comparator
		{
			public int compare(Object firstObject, Object secondObject)
			{
				Coin first = (Coin)firstObject;
				Coin second = (Coin)secondObject;
				
				if (first.getValue() > second.getValue())
				{
					return -1;
				}
				
				if (first.getValue() == second.getValue())
				{
					return 0;
				}
				
				return 1;
			}
		}
		
		Comparator calc = new CoinComparator();
		Collections.sort(coin, calc);
		
		String r = "Purse [coins = ";
		
		for (int i = 0; i < coin.size(); i++)
		{
			if (i > 0)
			{
				r = r + ",";
			}
			
			r = r + coin.get(i);
		}
		
		return r + "]";
	}
}