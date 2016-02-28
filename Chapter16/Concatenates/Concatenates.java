//Chapter 16 - Exercise 16.7
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_4

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class Concatenates
{
	public static void main (String[] args)
	{
		if (args.length < 2)
		{
			System.out.println("Usage : CatFile sourcefile1 sourcefile2 targetfile");
			return;
		}
		
		try
		{
			FileWriter out = new FileWriter (args[args.length - 1]);
			
			for (int i = 0; i < args.length-1; i++)
			{
				FileReader in = new FileReader (args[i]);
				boolean more = true;
				
				while (more)
				{
					int ic = in.read();
					if (ic == -1)
					{
						more = false;
					}
					
					else
					{
						out.write(ic);
					}
				}
				
				in.close();
			}
			
			out.close();
		}
		
		catch (IOException exception)
		{
			System.out.println (exception);
		}
	}
}










