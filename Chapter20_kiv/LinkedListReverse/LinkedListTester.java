//Chapter 20 - Exercise 20.3

public class LinkedListTester
{
	public static void main (String[] args)
	{
		LinkedList staff = new LinkedList();
		staff.addFirst("Tom");
		staff.addFirst("Romeo");
		staff.addFirst("Harry");
		staff.addFirst("Dick");
		
		//print all element
		LinkedList.Iterator iterator = staff.listIterator();
		
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();
		
		staff.reverse();
		
		iterator = staff.listIterator();
		
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();
	}
}