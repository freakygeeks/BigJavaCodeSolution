//Chapter 15 - Project 15.1

import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

public class WebPage
{
	private String address;
	
	public WebPage(String anAddress)
	{
		address = anAddress;
	}
	
	public String readText() throws IOException, MalformedURLException
	{
		URL u = new URL(address);
		URLConnection connection = u.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader (new InputStreamReader(in));
		
		boolean done = false;
		String output = " ";
		
		while(!done)
		{
			String input = reader.readLine();
			
			if (input == null)
			{
				done = true;
			}
			else 
			{
				output = output + input + "\n";
			}
		}
		
		return output;
	}
}






























