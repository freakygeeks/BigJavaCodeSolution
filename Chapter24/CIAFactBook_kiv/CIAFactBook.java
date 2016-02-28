//Chapter 24 - Project 24.2
//https://www.cia.gov/library/publications/the-world-factbook/geos/af.html

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CIAFactBook
{
	public static void main (String[] args) throws IOException
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Please enter the country code (e.g : my) : ");
		String country = in.nextLine();
		
		//get command line arguments
		String urlString = "https://www.cia.gov/library/publications/the-world-factbook/geos/" + country + ".html";
		
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
			
			//search for country fullname
			if (input.contains("Introduction ::"))
			{
				String[] tokens = input.split("<|>");
				String b;
				
				for (int i = 0; i < tokens.length; i++)
				{
					String a;
					
					a = tokens[i];
					//System.out.println(i + " : " + a);
				}
				
				String fullname = tokens[6];
				System.out.println("Country fullname : " + fullname);
			}
			
			//search for capital city
			if (input.contains("<div><span class=category>name: </span><span class=category_data>"))
			{
				if (input.contains("\""))
				{
					return;
				}
				String[] tokens = input.split("<|>");
				String b;
				
				for (int i = 0; i < tokens.length; i++)
				{
					String a;
					
					a = tokens[i];
					//System.out.println(i + " : " + a);
				}
				
				String capital = tokens[8];
				System.out.println("Capital City : " + capital);
			}
			
			//search area
			if (input.contains("<div><span class=category>total: </span><span class=category_data>"))
			{
				if (input.contains("sq km"))
				{
				String[] tokens = input.split("<|>");
				String b;
				
				for (int i = 0; i < tokens.length; i++)
				{
					String a;
					
					a = tokens[i];
					//System.out.println(i + " : " + a);
				}
				
				String area = tokens[8];
				System.out.println("Total area : " + area);
				}
			}
		}
	}
}
