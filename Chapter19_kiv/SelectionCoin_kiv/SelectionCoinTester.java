//Chapter 19 - Exercise 19.2

import java.util.Arrays;

public class SelectionCoinTester
{
	public static void main (String[] args)
	{
		Coin[] a = {new Coin(0.05, "Nickel"),
					new Coin(0.05, "Nickel"),
					new Coin(0.25, "Quarter"),
					new Coin(0.01, "Penny"),
					new Coin(0.1, "Dime")
					};
					
		SelectionCoin s = new SelectionCoin(a);
		s.sort();
		System.out.println(Array.toString(a));
		System.out.println("Expected: [Coin[value=0.01,name=Penny], Coin[value=0.05,name=Nickel], Coin[value=0.05,name=Nickel], Coin[value=0.1,name=Dime], Coin[value=0.25,name=Quarter]]");
	}
}