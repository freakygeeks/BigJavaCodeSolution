//Chapter 19 - Exercise 19.7

import javax.swing.JOptionPane;

public class CoinTester
{
	public static void main (String[] args)
	{
		double NICKEL = 0.05;
		double DIME = 0.1;
		double QUARTER = 0.25;
		
		Purse myPurse = new Purse();
		
		boolean done = false;
		
		while (!done)
		{
			String input = JOptionPane.showInputDialog("Enter coin name or Cancel");
			
			if (input ==  null)
			{
				done = true;
			}
			
			else
			{
				double value = 0;
				
				if (input.equals("nickel"))
				{
					value = NICKEL;
				}
				
				else if (input.equals("dime"))
				{
					value = DIME;
				}
				
				else if (input.equals("quarter"))
				{
					value = QUARTER;
				}
				
				if (value != 0)
				{
					Coin c = new Coin (value, input);
					myPurse.add(c);
					System.out.println("The contents of the purse is " + myPurse);
				}
			}
		}
		
		System.exit(0);
	}
}