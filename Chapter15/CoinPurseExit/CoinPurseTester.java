//Chapter 15 - Exercise 15.4

import javax.swing.JOptionPane;
import java.util.NoSuchElementException;

public class CoinPurseTester
{
	public static void main (String[] args)
	{
		boolean done = false;
		
		String input = JOptionPane.showInputDialog ("Enter coin value and name");
		
		Purse myPurse = new Purse();
		int chance = 0;
		
		while (!done)
		{
			try
			{
				myPurse.read(input);
			}
			
			catch (NoSuchElementException exception)
			{
				System.out.println ("Input error " + exception);
			}
			
			catch (NumberFormatException exception)
			{
				System.out.println ("Input error " + exception);
				chance++;
			}
			
			if (!done)
			{
				if (chance == 2)
				{
					done = true;
				}
				
				input = JOptionPane.showInputDialog("Enter another coin. Press Q to exit");
				
				if (input.equalsIgnoreCase("Q"))
				{
					done = true;
				}
			}
		}
		
		System.out.println("Total = " + myPurse.getTotal());
		System.exit(0);
	}
}



