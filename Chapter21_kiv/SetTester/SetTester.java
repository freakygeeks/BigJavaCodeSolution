//Chapter 21 - Example 21.1

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetTester
{
	public static void main (String[] args)
	{
		Set<String> names = new HashSet<String>();
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while (!done)
		{
			System.out.print("Add name, Q when done : ");
			String input = in.next();
			
			if (input.equalsIgnoreCase("Q"))
			{
				done = true;
			}
			
			else
			{
				names.add(input);
				print(names);
			}
		}
		
		done = false;
		while (!done)
		{
			System.out.println("Remove names, Q when done");
			String input = in.next();
			
			if (input.equalsIgnoreCase("Q"))
			{
				done = true;
			}
			
			else
			{
				names.remove(input);
				print(names);
			}
		}
	}
	
	//print contents of a set strings
	private static void print (Set<String> s)
	{
		System.out.print("{");
		
		for (String element : s)
		{
			System.out.print(element);
			System.out.print(" ");
		}
		
		System.out.println("}");
	}
}














