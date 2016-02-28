//Chapter 16 - Exercise 16.2

import java.io.File;
import java.io.IOException;

public class CaesarCipherTester
{
	public static void main (String[] args)
	{
		boolean decrypt = false;
		boolean encrypt = false;
		String key = null;
		File inFile = null;
		File outFile = null;
		int type = 0;

		if (args.length < 2 || args.length > 4)
		{
			System.out.println ("Usage : java CaesarCipherTester1 [-e/d] [-kn] inFile outFile");
			System.exit(1);
		}
		
		try
		{
			for (int i = 0; i < args.length; i++)
			{
				
				if (args[i].substring(0,1).equals("-"))
				{
					String option = args[i].substring(1,2);
					
					if(option.equalsIgnoreCase("e"))
					{	
						type = CaesarCipher.E;
						decrypt = true;
					}
					
					if (option.equalsIgnoreCase("d"))
					{
						type = CaesarCipher.D;
						encrypt = true;
					}
					
					else if (option.equalsIgnoreCase("k"))
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
				System.out.println ("Usage : java CaesarCipherTester1 [-d/e] [-kn] inFile outFile");
				System.exit(1);
			}
			
			CaesarCipher cipher = new CaesarCipher(key,type);
			cipher.processFile(inFile, outFile);
		}
		
		catch (IOException exception)
		{
			System.out.println ("Error processing file : " + exception);
		}
	}
}






















