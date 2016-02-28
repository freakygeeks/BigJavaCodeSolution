//Chapter 15 - Exercise 15.7

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class CoinFileTester
{
	public static void main (String[] args)
	{
		boolean done = false;
		Scanner in = new Scanner(System.in);
		
		ArrayList<CoinFile> list = null;
		
		while (!done)
		{
			System.out.print ("Filename : " );
			String filename = in.next();
			
			try 
			{
				list = CoinFile.readFile(filename);
				done = true;
			}
			
			catch (IOException exception)
			{
				exception.printStackTrace();
			}
		}
		
		double total = 0;
		for (CoinFile c : list)
		{
			total = total + c.getValue();
			
		}
		
		System.out.println ("Total = " + total);
	}
}
























