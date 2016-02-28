//Chapter 24 - Exercise 24.4
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_4

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
   This program tests the bank server.
*/
public class BankClient
{      
   public static void main(String[] args) throws IOException
   {
      final int SBAP_PORT = 8889;
      Socket s = new Socket("localhost", SBAP_PORT);
      InputStream instream = s.getInputStream();
      OutputStream outstream = s.getOutputStream();
      Scanner in = new Scanner(instream);
      PrintWriter out = new PrintWriter(outstream); 
      
	  try
	  {
		String command = "DEPOSIT 3 1000\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		String response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "WITHDRAW 3 5000\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);

		command = "DEPOSIT -3 1000\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "DEPOSIT 3 5000\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "DEPOSIT 30 500\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "DEPOSIT 3 -30\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "WRONG 3\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "BALANCE 3\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving: " + response);
      
		command = "QUIT\n";
		System.out.print("Sending: " + command);
		out.print(command);
		out.flush();
	  }
	  catch (NoSuchAccountException exception)
	  {
		  System.out.println ("307 No Such Account ");//+ exception.getMessage());
	  }
	  catch (InsufficientFundsException exception)
	  {
		  System.out.println ("300 Amount is negative");// + exception.getMessage());
	  }

	s.close();
      
	System.exit(0);
   }
}
