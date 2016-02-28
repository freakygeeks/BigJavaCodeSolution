//Chapter 20 - Example 20.1

import java.util.LinkedList;
import java.util.ListIterator;

public class ListTester
{
	public static void main (String[] args)
	{
		LinkedList<String> staff = new LinkedList<String>();
		staff.addLast("Dick");
		staff.addLast("Harry");
		staff.addLast("Romeo");
		staff.addLast("Tom");
		
		ListIterator<String> iterator = staff.listIterator(); // |DHRT
		iterator.next(); // D|HRT
		iterator.next(); // |DH|RT
		
		iterator.add("Juliet"); //DHJ|RT
		iterator.add("Nina"); // DHJN|RT
		
		iterator.next(); // DHJNR|T
		
		iterator.remove(); // DHJN|T
		
		for (String name : staff)
		{
			System.out.println(name);
		}
		
	}
}