//Chapter 21 - Exercise 21.15

import javax.swing.JOptionPane;

public class PrePostOrderTester
{
	public static void main (String[] args)
	{
		PrePostOrder t = new PrePostOrder();
		
		boolean done = false;
		
		while (!done)
		{
			String input = JOptionPane.showInputDialog("Enter a word or Cancel to quit : ");
			
			if (input == null)
			{
				done = true;
			}
			
			else
			{
				t.insert(input);
			}
		}
		
		done = false;
		
		while (!done)
		{
			String input = JOptionPane.showInputDialog("Enter PRE, IN, POST : ");
			
			if (input == null)
			{
				done = true;
			}
			
			else if (input.equalsIgnoreCase("PRE"))
			{
				t.printPreOrder();
			}
			
			else if (input.equalsIgnoreCase("IN"))
			{
				t.print();
			}
			
			else if (input.equalsIgnoreCase("POST"))
			{
				t.printPostOrder();
			}
		}
		
		System.exit(0);
	}
}




















