//Chapter 16 - Exercise 16.11
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_11

import java.io.IOException;

public class TabExpander
{
	public static final int TABS = 3;
	
	public static void main (String[] args)
	{
		int col = 0;
		boolean done = false;
		
		try
		{
			while (!done)
			{
				int ic = System.in.read();
				if (ic == -1)
				{
					done = true;
				}
				
				else
				{
					char ch = (char) ic;
					
					if (ch == '\n' || ch == '\r')
					{
						col = 0;
					}
					
					else if (ch == '\t')
					{
						boolean done2 = false;
						while (!done2)
						{
							System.out.print(" ");
							col++;
							
							if (col % TABS == 0)
							{
								done2 = true;
							}
						}
					}
					
					else
					{
						System.out.print(ch);
						col++;
					}
				}
			}
		}
		
		catch (IOException exception)
		{
			System.out.println ("Input/Output Exception " + exception);
		}
	}
}