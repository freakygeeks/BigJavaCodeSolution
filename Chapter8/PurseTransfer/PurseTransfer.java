//Chapter8 - Exercise P8.4

import java.util.ArrayList;
import java.util.Collections;
public class PurseTransfer
{
	private ArrayList<String> coinName;
	
	public PurseTransfer()
	{
	coinName = new ArrayList<String>();
	}
	
	
	public void addCoin(String coin)
	{
	coinName.add(coin);
	}
	
	public void removeCoin()
	{
	coinName.clear();
	}
	
	/*
	public void addCoin(String[] coin)
	{
	for(String s : coin)
		{
		coinName.add(s);
		}
	}
	*/
	
	public String toString()
	{
	return coinName.toString();
	}
	
	public String reverse()
	{
	/*
	Collections.reverse(coinName);
	return coinName.toString();
	*/
	ArrayList<String> rvs = new ArrayList<String>(coinName);//making copy of newPurse so that reversing won't affect on it directly.
    Collections.reverse(rvs);

	return rvs.toString();
	}
	
	public void transfer(PurseTransfer other)
	{
	for(String o : other.coinName)
		{
		addCoin(o);
		}
	//other.removeCoin();
	other.coinName.removeAll(coinName);
	}
}