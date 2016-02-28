//Chapter 20 - Exercise 20.5

public class LinkedListTester
{
	public static void main (String[] args)
	{
		LinkedList staff = new LinkedList();
		staff.addFirst("Tom");
		staff.addFirst("Romeo");
		staff.addFirst("Harry");
		staff.addFirst("Dick");
		
		LinkedList.Iterator iterator = staff.listIterator();
		
		while (staff.size() > 0)
		{
			System.out.println(staff.size());
			System.out.println(iterator.next());
			iterator.remove();
		}
		
		System.out.println(staff.size());
	}
}