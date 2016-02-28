//Chapter 22 - Example 22.2

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTester
{
	public static void main (String[] args)
	{
		LinkedList<String> staff = new LinkedList<String>();
		staff.addLast("Dick");
		staff.addLast("Harry");
		staff.addLast("Romeo");
		staff.addLast("Tom");
		
		ListIterator<String> iterator = staff.listIterator();
		iterator.next();
		iterator.next();
		
		iterator.add("Juliet");
		iterator.add("Nina");
		iterator.next();
		
		iterator.remove();
		
		iterator = staff.listIterator();
		
		while (iterator.hasNext())
		{
			String element = iterator.next();
			System.out.println(element);
		}
	}
}