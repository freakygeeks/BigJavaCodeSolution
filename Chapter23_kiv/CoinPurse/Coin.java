//Chapter 23 - Exercise 23

public class Coin
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
	
	public boolean equals (Object otherObject)
	{
		Coin other = (Coin)otherObject;
		return name.equals(other.name) && value == other.value;
	}
}