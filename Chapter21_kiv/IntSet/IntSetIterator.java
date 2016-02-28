//Chapter 21 - Exercise 21.9

import java.util.Iterator;

public class IntSetIterator
{
	private Iterator iterator;
	
	public IntSetIterator(Iterator iter)
	{
		iterator = iter;
	}
	
	public boolean hasNext()
	{
		return iterator.hasNext();
	}
	
	public int next()
	{
		Integer element = (Integer)iterator.next();
		return element.intValue();
	}
}