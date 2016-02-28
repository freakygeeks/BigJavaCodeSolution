//Chapter 15 - Exercise 15.4

import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class Coin
{
	private double value;
	private String name;
	
	public Coin()
	{
		value = 0;
		name = " ";
	}
	
	public Coin (double aValue, String aName)
	{
		value = aValue;
		name = aName;
	}
	
	public boolean read (String input) throws NoSuchElementException
	{
		StringTokenizer t = new StringTokenizer (input);
		
		if (t == null)
		{
			return false;
		}
		
		value = Double.parseDouble (t.nextToken());
		name = t.nextToken();
		
		if (name == null) throw new NoSuchElementException ("Coin name expected");
		{
			return true;
		}
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return name;
	}
}
