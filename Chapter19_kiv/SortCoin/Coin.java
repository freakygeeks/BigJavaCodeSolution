//Chapter 19 - Exercise 19.7
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_6

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
	
	public String toString()
	{
		return "Coin [value = " + value + " , name = " + name + "]";
	}
}