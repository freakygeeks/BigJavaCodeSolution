//Chapter 20 - Exercise 20.3

import java.util.NoSuchElementException;

public class LinkedList
{
	private Link first;
	
	public LinkedList()
	{
		first = null;
	}
	
	public void reverse()
	{
		if (first == null)
		{
			return;
		}
		
		Link previous = first;
		Link current = first.next;
		first.next = null;
		
		while (current != null)
		{
			Link next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		first = previous;
	}
	
	//return first element in the linked list
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
	
	//add element to the front of linked list
	public void addFirst (Object obj)
	{
		Link newLink = new Link();
		newLink.data = obj;
		newLink.next = first;
		first = newLink;
	}
	
	//return iterator for iterating list
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
		
		//move iterator past next element
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
		
		//add an element before iterator position and moves past inserted element
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
		
		//remove last traversed element
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

















