//Chapter 26 - Exercise 26.3

public class Purse
{
	private double total;
	
	public Purse()
	{
		total = 0;
	}
	
	public void add (Coin aCoin)
	{
		total = total + aCoin.getValue();
	}
	
	public double getTotal()
	{
		return total;
	}
}