//Chapter 20 - Example 20.2

import java.util.NoSuchElementException;

public class LinkedList
{
	private Node first;
	
	public LinkedList()
	{
		first = null;
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
		
		Object element = first.data;
		first = first.next;
		return element;
	}
	
	//add element to front of linked list
	public void addFirst (Object element)
	{
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}
	
	//return iterator for iterating through list
	public ListIterator listIterator()
	{
		return new LinkedListIterator();
	}
	
	
	class Node
	{
		public Object data;
		public Node next;
	}
	
	class LinkedListIterator implements ListIterator
	{
		private Node position;
		private Node previous;
		
		public LinkedListIterator()
		{
			position = null;
			previous = null;
		}
		
		//move iterator past the next element
		public Object next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			
			previous = position;
			
			if (position == null)
			{
				position = first;
			}
			
			else
			{
				position = position.next;
			}
			
			return position.data;
		}
	
		//test if there is an element after the iterator position
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
	
		//add element before the iterator position
		public void add (Object element)
		{
			if (position == null)
			{
				addFirst(element);
				position = first;
			}
		
			else
			{
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
		
			previous = position;
		}
	
		//remove the last tranversed element
		public void remove()
		{
			if (previous == position)
			{
				throw new IllegalStateException();
			}
		
			if (position == first)
			{
				removeFirst();
			}
		
			else
			{
				previous.next = position.next;
			}
		
			position = previous;
		}
	
		//set last tranversed element to different value
		public void set (Object element)
		{
			if (position == null)
			{
				throw new NoSuchElementException();
			}
		
			position.data = element;
		}
	}
}