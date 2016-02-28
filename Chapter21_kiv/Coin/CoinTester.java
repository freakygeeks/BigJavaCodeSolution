//Chapter 21 - Example 21.4

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CoinTester
{
	public static void main (String[] args)
	{
		Coin coin1 = new Coin (0.25, "quarter");
		Coin coin2 = new Coin (0.25, "quarter");
		Coin coin3 = new Coin (0.05, "nickel");
		
		System.out.println("hash code of coin1 = " + coin1.hashCode());
		System.out.println("hash code of coin1 = " + coin2.hashCode());
		System.out.println("hash code of coin1 = " + coin3.hashCode());
		
		Set<Coin> coins = new HashSet<Coin>();
		coins.add(coin1);
		coins.add(coin2);
		coins.add(coin3);
		
		for (Coin c : coins)
		{
			System.out.println(c);
		}
	}
}