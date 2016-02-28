//Chapter 17 - Exercise 17.9

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class VendingMachineMenu
{
	private BufferedReader console;
	
	public VendingMachineMenu()
	{
		console = new BufferedReader (new InputStreamReader(System.in));
	}
	
	public void run (VendingMachine machine) throws IOException
	{
		boolean more = true;
		
		while (more)
		{
			System.out.println ("S)how products I)nsert coin B)uy A)add product R)remove coins Q)uit");
			String command = console.readLine().toUpperCase();
			
			if (command.equals("S"))
			{
				machine.printProductTypes();
			}
			
			else if (command.equals("I"))
			{
				System.out.println("Coin value : ");
				String input = console.readLine();
				double value = Double.parseDouble(input);
				machine.addCoin(new Coin(value));
			}
			
			else if (command.equals("R"))
			{
				machine.removeMoney();
			}
			
			else if (command.equals("B"))
			{
				System.out.println("Product : ");
				String description = console.readLine();
				machine.buyProduct(description);
			}
			
			else if (command.equals("A"))
			{
				System.out.println ("Description : ");
				String description = console.readLine();
				
				System.out.println ("Price : ");
				String input = console.readLine();
				double price = Double.parseDouble(input);
				
				System.out.println("Quantity : ");
				input = console.readLine();
				int quantity = Integer.parseInt(input);
				
				machine.addProduct (new Product(description, price), quantity);				
			}
			
			else if (command.equals("Q"))
			{
				more = false;
			}
		}
	}
}



















