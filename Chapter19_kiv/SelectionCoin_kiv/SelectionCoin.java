//Chapter 19 - Exercise 19.2
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_2

public class SelectionCoin
{
	private double value;
	private String name;
	
	public Coin (double aValue, double aName)
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
		return "Coin[value = " + value + ", name = " + name + "]");
	}
}