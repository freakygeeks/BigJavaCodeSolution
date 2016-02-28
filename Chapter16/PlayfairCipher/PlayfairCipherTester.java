//Chapter 16 - Exercise 16.5

import java.io.File;
import java.io.IOException;

public class PlayfairCipherTester
{
	public static void main (String[] args)
	{
		boolean decrypt = false;
		String key = null;
		File inFile = null;
		File outFile = null;
		
		if (args.length < 2 || args.length > 4)
		{
			System.out.println ("Usage : java PlayfairCipherTester [-d] [-kn] inFile outFile");
			System.exit(1);
		}
		
		try
		{
			for (int i = 0; i < args.length; i++)
			{
				if (args[i].substring(0,1).equals("-"))
				{				
					String option = args[i].substring(1,2);
					
					if(option.equals("d"))
					{
						decrypt = true;
					}
					
					else if (option.equals("k"))
					{
						key = args[i].substring(2);
					}
				}
				
				else
				{
					if (inFile == null)
					{
						inFile = new File (args[i]);
					}
					
					else if (outFile == null)
					{
						outFile = new File (args[i]);
					}
				}
			}
			
			if (inFile == null || outFile == null || key == null)
			{
				System.out.println ("Usage : java PlayfairCipher [-d] [-kn] inFile outFile");
				System.exit(1);
			}
			
			PlayfairCipher cipher = new PlayfairCipher(key);
			cipher.processFile(inFile, outFile);
		}
		
		catch (IOException exception)
		{
			System.out.println (exception);
		}
	}
}