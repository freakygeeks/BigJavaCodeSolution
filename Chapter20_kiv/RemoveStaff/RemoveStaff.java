//Chapter 20 - Exercise 20.1

import java.util.LinkedList;
import java.util.ListIterator;

public class RemoveStaff
{
	public static void main (String[] args)
	{
		LinkedList staff = new LinkedList();
		staff.addLast("Dick");
		staff.addLast("Harry");
		staff.addLast("Romeo");
		staff.addLast("Tom");
		
		downsize(staff);
		
		ListIterator iterator = staff.listIterator();
		
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	public static void downsize (LinkedList staff)
	{
		ListIterator iterator = staff.listIterator();
		
		while (iterator.hasNext())
		{
			iterator.next();
			iterator.remove();
			
			if (iterator.hasNext())
			{
				iterator.next();
			}
		}
	}
}