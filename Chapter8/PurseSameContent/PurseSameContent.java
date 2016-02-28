//Chapter8 - Exercise P8.5

import java.util.ArrayList;
import java.util.Collections;
public class PurseSameContent
{
	private ArrayList<String> coinName;
	
	public PurseSameContent()
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
	
	public void transfer(PurseSameContent other)
	{
	for(String o : other.coinName)
		{
		addCoin(o);
		}
	//other.removeCoin();
	other.coinName.removeAll(coinName);
	}
	
	public boolean sameContent(PurseSameContent other)
	{
	boolean content = false;
	for(int i = 0; i <  coinName.size(); i++)
		{
		if((coinName.get(i).equals(other.coinName.get(i))))
			content = true;
		}
	return content;
	}
}