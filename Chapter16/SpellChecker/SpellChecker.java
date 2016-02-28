//Chapter 16 - Exercise 16.9

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class SpellChecker
{
	private String filename;
	private ArrayList wordList;
	
	public SpellChecker(String wordFileName) throws IOException
	{
		filename = wordFileName;
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		wordList = new ArrayList();
		boolean more = true;
		
		while (more)
		{
			String w = in.readLine();
			if (w == null)
			{
				more = false;
			}
			
			else
			{
				wordList.add(w.toLowerCase());
			}
		}
		
		in.close();
	}
	
	public boolean check (String word)
	{
		boolean isFound = false;
		
		for (int i = 0; i < wordList.size(); i++)
		{
			if (word.equals(wordList.get(i)))
			{
				isFound = true;
			}
		}
		
		return isFound;
	}
}






























