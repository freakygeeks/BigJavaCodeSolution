//Chapter 23 - Exercise 23.7

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class FindThread extends Thread
{
	private String target;
	private String filename;
	private FileReader fin;
	private BufferedReader in;
	
	public FindThread (String aTarget, String aFilename)
	{
		target = aTarget;
		filename = aFilename;
	}
	
	public void run()
	{
		String line;
		
		try
		{
			fin = new FileReader(filename);
			in = new BufferedReader(fin);
			
			while ((line = in.readLine()) != null)
			{
				if ((line.indexOf(target)) != -1)
				{
					System.out.println(filename + " : " + line);
				}
			}
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println(filename + " not found!");
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}




















