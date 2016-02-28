//Chapter 16 - Example 16.4

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class BankDataTester
{
	public static void main (String[] args) throws IOException
	{
		Scanner in = new Scanner (System.in);
		BankData data = new BankData();
		
		try
		{
			data.open("bank.txt");
			
			boolean done = false;
			while (!done)
			{
				System.out.print ("Account Number : ");
				int accountNumber = in.nextInt();
				
				System.out.print ("Amount to deposit : ");
				double amount = in.nextDouble();
				
				int position = data.find(accountNumber);
				
				BankAccount account;
				
				if (position >= 0)
				{
					account = data.read(position);
					account.deposit(amount);
					System.out.println ("new balance = " + account.getBalance());
				}
				
				else //add account
				{
					account = new BankAccount (accountNumber, amount);
					position = data.size();
					
					System.out.println ("adding new account : ");
				}
				
				data.write(position, account);
				
				System.out.print ("Done? Y/N ");
				String input = in.next();
				
				if (input.equalsIgnoreCase("Y"))
				{
					done = true;
				}
			}
		}
		
		finally
		{
			data.close();
		}
	}
}











































