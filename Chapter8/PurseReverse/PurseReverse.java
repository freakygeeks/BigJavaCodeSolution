//Chapter8 - Exercise P8.3

import java.util.ArrayList;
import java.util.Collections;

public class PurseReverse
{
	private ArrayList<String> coinName;
	
	public PurseReverse()
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
}