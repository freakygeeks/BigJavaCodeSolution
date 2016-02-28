//Chapter 21 - Exercise 21.3

import java.util.Iterator;
import java.util.Set;

public class HashSetDebugTester
{
	public static void main (String[] args)
	{
		HashSetDebug names = new HashSetDebug(101);
		
		names.add("Sue");
		names.add("Harry");
		names.add("Nina");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");
		
		System.out.println("After adding");
		
		names.debug();
		names.remove("Romeo");
		names.remove("George");
		
		System.out.println("After removing");
		names.debug();
		
		Iterator iter = names.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}

	}
}