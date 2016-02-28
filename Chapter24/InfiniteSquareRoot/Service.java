//Chapter 24 - Exercise 24.5

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class Service
{
	private Socket s;
	
	public Service (Socket aSocket)
	{
		s = aSocket;
	}
	
	//compute square root of number from a socket
	public void doService() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream());
		String line = in.readLine();
		
		try
		{
			double response = Math.sqrt(Double.parseDouble(line));
			System.out.println("Sending : " + response);
			out.println(response);//server send output to the client in string
		}
		catch (NumberFormatException e)
		{
			System.out.println("Sending : NaN");
			out.println("NaN");
		}
		
		out.flush();
	}
}