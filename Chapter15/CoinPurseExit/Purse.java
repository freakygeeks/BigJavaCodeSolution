//Chapter 15 - Exercise 15.4

public class Purse
{
	private double total;
	
	public Purse()
	{
		total = 0;
	}
	
	public void read (String input)
	{
		boolean done = false;
		Coin c = new Coin();
		
		if (c.read(input))
		{
			add(c);
		}
		else
		{
			done = true;
		}
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

