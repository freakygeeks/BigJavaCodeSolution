//Chapter 24 - Exercise 24.2
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_2
//http://www.gotoquiz.com/web-coding/programming/java-programming/how-to-extract-titles-from-web-pages-in-java/

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class GetTitle
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
		System.out.println("Getting / from " + host);
		
		//open socket
		final int HTTP_PORT = 80;
		Socket s = new Socket(host, HTTP_PORT);
		
		//get streams
		InputStream instream = s.getInputStream();
		OutputStream outstream = s.getOutputStream();
		
		//turn streams into scanners and writers
		Scanner in = new Scanner (instream);
		PrintWriter out = new PrintWriter(outstream);
		
		//send command
		String command = "GET " + resource + " HTTP/1.0\n\n";
		out.print(command);
		out.flush();
		
		//read server response
		while (in.hasNextLine())
		{
			String input = in.nextLine();
			//System.out.println(input);
		}
		
		String title = TitleExtractor.getPageTitle("http://" + host);
		System.out.println(title);
		
		//close the socket at the end
		s.close();
	}
}
