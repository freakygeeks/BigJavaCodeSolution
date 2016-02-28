//Chapter 24 - Example 24.4

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BankClient
{
	public static void main (String[] args) throws IOException
	{
		final int SBAP_PORT = 8888;
		Socket s = new Socket("localhost", SBAP_PORT);
		InputStream instream = s.getInputStream();
		OutputStream outstream = s.getOutputStream();
		Scanner in = new Scanner(instream);
		PrintWriter out = new PrintWriter(outstream);
		
		String command = "DEPOSIT 3 1000\n";
		System.out.print("Sending : " + command);
		out.print(command);
		out.flush();
		String response = in.nextLine();
		System.out.println("Receiving : " + response);
		
		command = "DEPOSIT 5 1000\n";
		System.out.print("Sending : " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving : " + response);
		
		command = "WITHDRAW 3 500\n";
		System.out.print("Sending : " + command);
		out.print(command);
		out.flush();
		response = in.nextLine();
		System.out.println("Receiving : " + response);
		
		command = "QUIT\n";
		System.out.print("Sending : " + command);
		out.print(command);
		out.flush();
		
		s.close();
	}
}