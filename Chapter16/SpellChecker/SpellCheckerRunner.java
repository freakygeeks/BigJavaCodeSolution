//Chapter 16 - Exercise 16.9
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_6

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class SpellCheckerRunner
{
	private String filename;
	
	public SpellCheckerRunner(String aFilename)
	{
		filename = aFilename;
	}
	
	public String[] readWords() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		ArrayList w = new ArrayList();
		boolean more = true;
		
		while(more)
		{
			String word = in.readLine();
			if (word == null)
			{
				more = false;
			}
			
			else
			{
				w.add(word.toLowerCase());
			}
			
			if (w.size() % 1000 == 0)
			{
				System.out.println(w.size());
			}
		}
		
		in.close();
		
		String[] r = new String[w.size()];
		w.toArray(r);
		return r;
	}
	
	public int find (String s, String[] a)
	{
		return binarySearch(a, 0, a.length-1, s);
	}
	
	public int binarySearch (String[] v, int from, int to, String a)
	{
		if (from > to)
		{
			return -1;
		}
		
		int mid = (from + to) / 2;
		int diff = v[mid].compareTo(a);
		
		if (diff == 0)
		{
			return mid;
		}
		
		else if (diff < 0)
		{
			return binarySearch (v, mid + 1, to, a);
		}
		
		else
		{
			return binarySearch (v, from, mid - 1, a);
		}
	}
}























