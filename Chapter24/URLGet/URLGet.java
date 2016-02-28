//Chapter 24 - Example 24.5

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLGet
{
	public static void main (String[] args) throws IOException
	{
		//get command line arguments
		String urlString;
		
		if(args.length == 1)
		{
			urlString = args[0];
		}
		else
		{
			urlString = "http://www.oracle.com/";
			System.out.println("Using " + urlString);
		}
		
		//open connection
		URL u = new URL (urlString);
		URLConnection connection = u.openConnection();
		
		//check if response code is HTTP_OK (200)
		HttpURLConnection httpConnection = (HttpURLConnection) connection;
		int code = httpConnection.getResponseCode();
		String message = httpConnection.getResponseMessage();
		System.out.println(code + " " + message);
		
		if (code != HttpURLConnection.HTTP_OK)
		{
			return;
		}
		
		//read server response
		InputStream instream = connection.getInputStream();
		Scanner in = new Scanner(instream);
		
		while (in.hasNextLine())
		{
			String input = in.nextLine();
			System.out.println(input);
		}
	}
}