//Chapter 24 - Example 24.4

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BankService implements Runnable
{
	private Socket s;
	private Scanner in;
	private PrintWriter out;
	private Bank bank;
	
	public BankService (Socket aSocket, Bank aBank)
	{
		s = aSocket;
		bank = aBank;
	}
	
	//run thread to get the input and output from server
	public void run()
	{
		try
		{
			try
			{
				in = new Scanner (s.getInputStream());
				out = new PrintWriter(s.getOutputStream());
				doService();
			}
			finally
			{
				s.close();
			}
		}
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
	}
	
	//execute all commands until QUIT command or end of inputs
	public void doService() throws IOException
	{
		while (true)
		{
			if (!in.hasNext())
			{
				return;
			}
			
			String command = in.next();
			
			if (command.equalsIgnoreCase("QUIT"))
			{
				return;
			}
			else
			{
				executeCommand(command);
			}
		}
	}
	
	//execute a single command
	public void executeCommand (String command)
	{
		int account = in.nextInt();
		
		if (command.equals("DEPOSIT"))
		{
			double amount = in.nextDouble();
			bank.deposit(account, amount);
		}
		else if (command.equals("WITHDRAW"))
		{
			double amount = in.nextDouble();
			bank.withdraw(account, amount);
		}
		else if (!command.equals("BALANCE"))
		{
			out.println("Invalid command");
			out.flush();
			return;
		}
		
		out.println(account + " " + bank.getBalance(account));
		out.flush();
	}
}













