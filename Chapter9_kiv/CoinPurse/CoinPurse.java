//Chapter 9 - Exercise 9.1

import javax.swing.JOptionPane;

public class CoinPurse
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
			
			if (input == null)
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
					Coin c = new Coin(value, input);
					myPurse.add(c);
					double totalValue = myPurse.getTotal();
					System.out.println("The total is " + totalValue);
				}
			}
		}
		System.exit(0);
	}
}