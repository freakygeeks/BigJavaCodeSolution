//Chapter8 - Exercise P8.6

import java.util.ArrayList;
import java.util.Collections;

public class PurseSameCoin
{
	private ArrayList<String> coinName;
	
	public PurseSameCoin()
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
	
	public void transfer(PurseSameCoin other)
	{
	for(String o : other.coinName)
		{
		addCoin(o);
		}
	//other.removeCoin();
	other.coinName.removeAll(coinName);
	}
	
	public boolean sameContent(PurseSameCoin other)
	{
	boolean content = false;
	for(int i = 0; i <  coinName.size(); i++)
		{
		if((coinName.get(i).equals(other.coinName.get(i))))
			content = true;
		}
	return content;
	}
	
	public boolean sameCoin(PurseSameCoin other)
	{
	boolean bcoin = false;
	for(int j = 0; j < coinName.size(); j ++)
		{
		if(coinName.contains(other.coinName.get(j))) //&& other.coinName.contains(coinName))
			{
			bcoin = true;
			}
		}
	return bcoin;	
	}
}