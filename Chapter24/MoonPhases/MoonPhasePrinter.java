//Chapter 24 - Exercise 24.10

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MoonPhasePrinter
{
	public static void main (String[] args) throws IOException
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Please enter the year (e.g : 1977) : ");
		int year = in.nextInt();
		
		System.out.print("Please enter the month (e.g : 9) : ");
		int month = in.nextInt();
		
		System.out.print("Please enter the day (e.g : 13) : ");
		int day = in.nextInt();

		//get command line arguments
		String urlString = "http://www.moongiant.com/phase/" + month + "/" + day + "/" + year;
		
		//open connection
		URL u = new URL (urlString);
		URLConnection connection = u.openConnection();
		
		//check if response code is HTTP_OK (200)
		HttpURLConnection httpConnection = (HttpURLConnection) connection;
		int code = httpConnection.getResponseCode();
		String message = httpConnection.getResponseMessage();
		//System.out.println(code + " " + message);
		
		if (code != HttpURLConnection.HTTP_OK)
		{
			return;
		}
		
		//read server response
		InputStream instream = connection.getInputStream();
		in = new Scanner(instream);
		
		while (in.hasNextLine())
		{
			String input = in.nextLine();
			//System.out.println(input);
			
			if (input.contains("Phase: "))
			{
				String[] tokens = input.split(",");
				String b;
				
				for (int i = 0; i < tokens.length; i++)
				{
					String a;
					
					a = tokens[i];
					//System.out.println(i + " : " + a);
				}
				
				String phase = tokens[10];
				System.out.println("Phase : " + phase);
			}
		}
	}
}