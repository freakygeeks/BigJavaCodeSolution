//Chapter 16 - Exercise 16.9

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SpellCheckerTester
{
	public static void main (String[] args)
	{
		if (args.length < 2)
		{
			System.out.println ("Usage : SpellChecker file wordFile");
			return;
		}
		
		try
		{
			SpellChecker sc = new SpellChecker(args[1]);
			
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			boolean more = true;
			
			while (more)
			{
				String line = in.readLine();
				
				if (line == null)
				{
					more = false;
				}
				
				else
				{
					StringTokenizer token = new StringTokenizer(line.toLowerCase());
					
					while (token.hasMoreTokens())
					{
						String word = token.nextToken();
						if (!sc.check(word))
						{
							System.out.println(word);
						}
					}
				}
			}
			
			in.close();
		}
		
		catch (IOException exception)
		{
			System.out.println(exception);
		}
	}
}

















