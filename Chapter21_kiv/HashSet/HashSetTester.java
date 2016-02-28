//Chapter 21 - Example 21.3

import java.util.Iterator;
import java.util.Set;

public class HashSetTester
{
	public static void main (String[] args)
	{
		HashSet names = new HashSet(101);
		
		names.add("Sue");
		names.add("Harry");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");
		names.remove("Romeo");
		names.remove("George");
		
		Iterator iter = names.iterator();
		
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
}