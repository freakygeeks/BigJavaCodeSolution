//Chapter 16 - Exercise 16.1

import java.io.FileReader;
import java.io.IOException;

public class FileCounter
{
	private int chars;
	private int words;
	private int lines;
	
	public FileCounter()
	{
		chars = 0;
		words = 0;
		lines = 0;
	}
	
	public void read (FileReader reader) throws IOException
	{
		boolean space = true;
		boolean more = true;
		
		while(more)
		{
			int ic = reader.read();
			if (ic == -1)
			{
				more = false;
			}
			else
			{
				chars++;
				char c = (char) ic;
				
				if (c == '\n')
				{
					lines++;
					space = true;
				}
				
				else if (c == ' ' || c == '\r')
				{
					space = true;
				}
				
				else
				{
					if (space)
					{
						words++;
						space = false;
					}
				}
			}
		}
	}
	
	public int getCharacterCount()
	{
		return chars;
	}
	
	public int getWordCount()
	{
		return words;
	}
	
	public int getLineCount()
	{
		return lines;
	}
}















































