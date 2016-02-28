//Chapter8 - Exercise P8.2

import java.util.ArrayList;

public class Purse
{
	private ArrayList<String> coinName;
	
	public Purse()
	{
	coinName = new ArrayList<String>();
	}
	
	/*
	public void addCoin(String coin)
	{
	coinName.add(coin);
	}
	*/
	
	public void addCoin(String[] coin)
	{
	for(String s : coin)
		{
		coinName.add(s);
		}
	}
	
	public String toString()
	{
	return coinName.toString();
	}
}