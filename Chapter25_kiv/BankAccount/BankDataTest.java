//Chapter 25 - Exercise 25.3

import java.io.IOException;
import java.sql.SQLException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class BankDataTest
{
	public static void main (String[] args) throws SQLException, IOException, ClassNotFoundException
	{
		if (args.length == 0)
		{
			System.out.println("Usage : java BankDataTest DBproperties");
			System.exit(0);
		}
		
		BankData data = new BankData();
				
		try
		{
			data.open(args[0]);
			boolean done = false;
			
			while (!done)
			{
				String input = JOptionPane.showInputDialog("Account number or " + data.size() + " for new account");
				
				if (input == null)
				{
					done = true;
				}
				
				else
				{
					int pos = Integer.parseInt(input);
					
					if (0 < pos && pos < data.size())
					{
						SavingsAccount account = data.read(pos);
						System.out.println("Account : " + pos + ", balance = " + account.getBalance() + ", interest rate = " + account.getInterestRate());
						account.addInterest();
						data.write(pos, account);
					}
					else if (pos > 0)
					{
						input = JOptionPane.showInputDialog("Balance");
						double balance = Double.parseDouble(input);
						input = JOptionPane.showInputDialog("Interest Rate");
						double interestRate = Double.parseDouble(input);
						
						SavingsAccount account = new SavingsAccount(interestRate);
						account.deposit(balance);
						data.write(data.size(), account);
					}
				}
			}
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			data.close();
			System.exit(0);
		}
	}
}



















