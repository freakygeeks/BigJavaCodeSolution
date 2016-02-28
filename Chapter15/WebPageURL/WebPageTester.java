//Chapter 15 - Project 15.1

import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.MalformedURLException;

public class WebPageTester
{
	public static void main (String[] args)
	{
		boolean done = false;
		String url = JOptionPane.showInputDialog("Enter a URL");
		
		while(!done)
		{
			try
			{
				WebPage reader = new WebPage(url);
				System.out.println(reader.readText());
				done = true;
			}
			
			catch (IOException exception)
			{
				System.out.println ("Input/output error " + exception);
			}
			
			if (!done)
			{
				url = JOptionPane.showInputDialog("Try another URL");
				
				if (url == null)
				{
					done = true;
				}
			}
		}
		
		System.exit(0);
	}
}



























