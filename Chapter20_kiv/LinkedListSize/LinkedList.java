//Chapter 20 - Exercise 20.5

import java.util.NoSuchElementException;

public class LinkedList
{
	private Link first;
	
	public LinkedList()
	{
		first = null;
	}
	
	public int size()
	{
		int s = 0;
		Link current = first;
		
		while (current != null)
		{
			s++;
			current = current.next;
		}
		
		return s;
	}
	
	//return first element in linked list
	public Object getFirst()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	//remove first element in linked list
	public Object removeFirst()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		
		Object obj = first.data;
		first = first.next;
		return obj;
	}
	
	//add element to front of linked list
	public void addFirst (Object obj)
	{
		Link newLink = new Link();
		newLink.data = obj;
		newLink.next = first;
		first = newLink;
	}
	
	//return iterator for iterating thru list
	public Iterator listIterator()
	{
		return new Iterator();
	}
	
	class Link
	{
		public Object data;
		public Link next;
	}
	
	class Iterator
	{
		private Link position;
		private Link previous;
		
		public Iterator()
		{
			position = null;
			previous = null;
		}
		
		//moves iterator past next element
		public Object next()
		{
			if (position == null)
			{
				position = first;
				return getFirst();
			}
			
			else
			{
				if (position.next == null)
				{
					throw new NoSuchElementException();
				}
				
				previous = position;
				position = position.next;
				return position.data;
			}
		}
		
		//test if there is an element after iterator
		public boolean hasNext()
		{
			if (position == null)
			{
				return first != null;
			}
			
			else
			{
				return position.next != null;
			}
		}
		
		//add an element befor iterator position
		public void add (Object obj)
		{
			if (position == null)
			{
				addFirst(obj);
			}
			
			else
			{
				Link newLink = new Link();
				newLink.data = obj;
				newLink.next = position.next;
				position.next = newLink;
				position = newLink;
				previous = null;
			}
		}
		
		//remove last traverse element
		public void remove()
		{
			if (position == first)
			{
				removeFirst();
			}
			
			else
			{
				if (previous == null)
				{
					throw new IllegalStateException();
				}
				
				previous.next = position.next;
				position = previous;
			}
			
			previous = null;
		}
	}
	
}























