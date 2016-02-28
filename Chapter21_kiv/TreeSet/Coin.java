//Chapter 21 - Example 21.7

public class Coin
{
	private double value;
	private String name;
	
	public Coin (double aValue, String aName)
	{
		value = aValue;
		name = aName;
	}
	
	//get coins
	public double getValue()
	{
		return value;
	}
	
	//get coin name
	public String getName()
	{
		return name;
	}
	
	public boolean equals (Object otherObject)
	{
		if (otherObject == null)
		{
			return false;
		}
		
		if (getClass() != otherObject.getClass())
		{
			return false;
		}
		
		Coin other = (Coin) otherObject;
		return value == other.value && name.equals(other.name);
	}
	
	public int hashCode()
	{
		int h1 = name.hashCode();
		int h2 = new Double(value).hashCode();
		final int HASH = 29;
		int h = HASH * h1 + h2;
		return h;
	}
	
	public String toString()
	{
		return "Coin[value = " + value + " , name = " + name + "]";
	}
}

















