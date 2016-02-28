//Chapter 19 - Exercise 19.5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class MergeSorterTester
{
	public static void main (String[] args)
	{
		String fileName = JOptionPane.showInputDialog("Enter the name of phonebook file : ");
		
		if (fileName == null)
		{
			System.exit(0);
		}
		
		LookupTable name = new LookupTable(1000);
		try
		{
			FileReader in = new FileReader(fileName);
			name.read(new BufferedReader(in));
		}
		catch (IOException exception)
		{
			System.out.println(exception);
			System.exit(1);
		}
		
		LookupTable number = new LookupTable(1000);
		number.reverse(name);
		boolean more = true;
		
		while (more)
		{
			String cmd = JOptionPane.showInputDialog("Lookup N)ame, P)hone number, Q)uit?");
			if (cmd == null)
			{
				more = false;
			}
			
			else if (cmd.equalsIgnoreCase("Q"))
			{
				more = false;
			}
			
			else if (cmd.equalsIgnoreCase("N"))
			{
				String n = JOptionPane.showInputDialog("Enter name : ");
				System.out.println("Phone number : " + name.lookup(n));
			}
			
			else if (cmd.equalsIgnoreCase("P"))
			{
				String n = JOptionPane.showInputDialog("Enter phone number : ");
				System.out.println("Name : " + number.lookup(n));
			}
		}
		
		System.exit(0);
	}
}