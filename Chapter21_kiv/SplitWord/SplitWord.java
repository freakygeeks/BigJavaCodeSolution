//Chapter 21 - Exercise 21.1

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SplitWord
{
	public static void main (String[] args) throws IOException
	{
		Set s = new TreeSet();
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter the sentence : ");
		String inputLine = console.readLine();
		StringTokenizer token = new StringTokenizer(inputLine);
		
		while (token.hasMoreTokens())
		{
			String word = token.nextToken();
			s.add(word);
		}
		
		Iterator iter = s.iterator();
		
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		System.out.println("size = " + s.size());
	}
}