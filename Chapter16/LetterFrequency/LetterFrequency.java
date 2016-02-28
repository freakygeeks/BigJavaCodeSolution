//Chapter 16 - Exercise 16.3
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch19/c19_exp_19_2

import java.io.FileReader;
import java.io.IOException;

public class LetterFrequency
{
	private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private int[] freq;
	private int total;
	
	public LetterFrequency()
	{
		total = 0;
	}
	
	public void read (FileReader reader) throws IOException
	{
		freq = new int[LETTERS.length()];
		boolean more = true;
		
		while (more)
		{
			int ic = reader.read();
			
			if(ic == -1)
			{
				more = false;
			}
			
			else
			{
				char ch = Character.toLowerCase((char)ic);
				int i = LETTERS.indexOf(ch);
				
				if(i >= 0)
				{
					freq[i]++;
					total++;
				}
			}
		}
		
		if (total == 0)
		{
			return;
		}
	}
	
	public double getFrequency(char c)
	{
		return 100.0*freq[LETTERS.indexOf(c)]/total;
	}
}


























































































































