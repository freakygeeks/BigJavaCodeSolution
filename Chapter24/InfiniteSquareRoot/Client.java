//Chapter 24 - Exercise 24.5

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
	public static void main (String[] args) throws IOException
	{
		final int PORT = 8888;
		Socket s;
		
		while (true)
		{
			BufferedReader jin = new BufferedReader(new InputStreamReader(System.in));
			String input;
			System.out.print("\nPlease enter a number : ");
			input = jin.readLine();
			
			s = new Socket ("localhost", PORT);
			
			//InputStream in = s.getInputStream();//client received input from server in char
			//OutputStream out = s.getOutputStream();//client send output to server in char
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream())); //change char input into string
			PrintWriter writer = new PrintWriter(s.getOutputStream());//change char output into string
			
			String response;
			writer.print(input + "\n");
			writer.flush();
			response = reader.readLine();//client receive input in string
			System.out.println("The square root of " + input + " is : " + response);
		}
	}
}