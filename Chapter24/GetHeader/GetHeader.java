//Chapter 24 - Exercise 24.1
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_1

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GetHeader
{
	public static void main (String[] args) throws IOException
	{
		//get command line arguments
		if (args.length != 2)
		{
			System.out.println ("Usage : java GetHeader host resource");
			System.exit(0);
		}
		
		String host = args[0];
		String resource = args[1];
		
		//open socket
		final int HTTP_PORT = 80;
		Socket s = new Socket(host, HTTP_PORT);
		
		//get streams
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		//turn stream into readers and writers
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);
		
		//send command
		String command = "GET /" + resource + " HTTP/1.0\n\n";
		writer.print(command);
		writer.flush();
		
		//read server response
		boolean done = false;
		while (!done)
		{
			String input = reader.readLine();
			
			//stop when see a blank line
			if (input.trim().length() == 0)
			{
				done = true;
			}
			else
			{
				System.out.println(input);
			}
		}
		
		//close socket at the end
		s.close();
	}
}