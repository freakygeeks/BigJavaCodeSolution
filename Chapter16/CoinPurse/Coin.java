//Chapter 16 - Exercise CoinPurse

import java.io.Serializable;

public class Coin implements Serializable
{
	private double value;
	private String name;
	
	public Coin (double aValue, String aName)
	{
		value = aValue;
		name = aName;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean equals(Object otherObject)
	{
		Coin other = (Coin)otherObject;
		return name.equals(other.name) && value == other.value;
	}
}