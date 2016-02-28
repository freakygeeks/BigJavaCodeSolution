//Chapter11 - Exercise P11.10

public class Coin implements Comparable<Coin>
{
	private double value;
	private String name;

	public Coin(double aValue, String aName)
	{
	value = aValue;
	name = aName;
	}
	
	public int compareTo (Coin aCoin)
	{
	if (value == aCoin.value)
		{
		return 0;
		}
	if (value > aCoin.value)
		{
		return 1;
		}
	else
		return -1;
	}
	
}