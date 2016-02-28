//Chapter 21 - Exercise 21.11

import java.util.TreeSet;
import java.util.Iterator;

public class IntSetEratosthenes
{
	private TreeSet elements;
	
	public IntSetEratosthenes()
	{
		elements = new TreeSet();
	}
	
	public void add (int x)
	{
		elements.add(new Integer(x));
	}
	
	public void remove (int x)
	{
		elements.remove(new Integer(x));
	}
	
	public void print()
	{
		System.out.print("{ ");
		Iterator iterator = elements.iterator();
		
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println("}");
	}
}
