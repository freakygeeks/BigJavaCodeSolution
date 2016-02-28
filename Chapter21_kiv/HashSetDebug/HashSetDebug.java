//Chapter 21 - Exercise 21.3

import java.util.Iterator;
import java.util.AbstractSet;

public class HashSetDebug extends AbstractSet
{
	private Link[] buckets;
	private int size;
	
	public HashSetDebug(int bucketsLength)
	{
		buckets = new Link[bucketsLength];
		size = 0;
	}
	
	//test for set membership
	public boolean contains (Object x)
	{
		int h = x.hashCode();
		
		if (h < 0)
		{
			h = -h;
		}
		
		h = h % buckets.length;
		
		Link current = buckets[h];
		
		while (current != null)
		{
			if (current.data.equals(x))
			{
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}
	
	//adds an element to this set
	public boolean add (Object x)
	{
		int h = x.hashCode();
		
		if (h < 0)
		{
			h = -h;
		}
		
		h = h % buckets.length;
		
		Link current = buckets[h];
		while (current != null)
		{
			if (current.data.equals(x))
			{
				return false;
			}		
			
			current = current.next;
		}
		
		Link newLink = new Link();
		newLink.data = x;
		newLink.next = buckets[h];
		buckets[h] = newLink;
		size++;
		return true;
	}
	
	//remove an object from this set
	public boolean remove (Object x)
	{
		int h = x.hashCode();
		
		if (h < 0)
		{
			h = -h;
		}
		
		h = h % buckets.length;
		
		Link current = buckets[h];
		Link previous = null;
		
		while (current != null)
		{
			if (current.data.equals(x))
			{
				if (previous == null)
				{
					buckets[h] = current.next;
				}
				
				else
				{
					previous.next = current.next;
				}
				
				size--;
				return true;
			}
			
			previous = current;
			current = current.next;
		}
		
		return false;
	}
	
	//prints all buckets
	public void debug()
	{
		for (int i = 0; i < buckets.length; i++)
		{
			if (buckets[i] != null)
			{
				System.out.print(i + " : ");
				for (Link c = buckets[i]; c != null; c = c.next)
				{
					System.out.print(" " + c.data);
				}
				System.out.println();
			}
		}
	}
	
	//return an iterator that traverses the element of this set
	public Iterator iterator()
	{
		return new HashSetIterator();
	}
	
	//get number of elements in this set
	public int size()
	{
		return size;
	}
	
	class Link
	{
		public Object data;
		public Link next;
	}
	
	class HashSetIterator implements Iterator
	{
		private int bucket;
		private Link current;
		private int previousBucket;
		private Link previous;
		
		public HashSetIterator()
		{
			bucket = 0;
			previous = null;
			previousBucket = buckets.length;
			
			//set bucket to the index of the first nonempty bucket
			while (bucket < buckets.length && buckets[bucket] == null)
			{
				bucket++;
			}
			
			if (bucket < buckets.length)
			{
				current = buckets[bucket];
			}
			
			else
			{
				current = null;
			}
		}
		
		public boolean hasNext()
		{
			return current != null;
		}
		
		public Object next()
		{
			Object r = current.data;
			
			//move to next bucket
			if (current.next == null)
			{
				previousBucket = bucket;
				bucket++;
				
				while (bucket < buckets.length && buckets[bucket] == null)
				{
					bucket++;
				}
				
				if (bucket < buckets.length)
				{
					current = buckets[bucket];
				}
				
				else
				{
					current = null;
				}
			}
			
			else
			{
				previous = current;
				current = current.next;
			}
			
			return r;
		}
		
		public void remove()
		{
			if (previous != null)
			{
				previous.next = previous.next.next;
			}
			
			else if (previousBucket < buckets.length)
			{
				buckets[previousBucket] = null;
			}
			
			else
			{
				throw new IllegalStateException();
			}
			
			previous = null;
			previousBucket = buckets.length;
		}
	}
}

















