//Chapter 17 - Exercise 17.9

import java.io.IOException;

public class VendingMachineTester
{
	public static void main (String[] args) throws IOException
	{
		VendingMachine machine = new VendingMachine();
		VendingMachineMenu menu = new VendingMachineMenu();
		menu.run(machine);
	}
}