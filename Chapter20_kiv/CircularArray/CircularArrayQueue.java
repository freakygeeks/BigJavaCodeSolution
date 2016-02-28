//Chapter 20 - Exercise 20.9

public class CircularArrayQueue
{
	private int head;
	private int tail;
	private int length;
	private Object[] elements;
	
	public CircularArrayQueue(int capacity)
	{
		elements = new Object[capacity];
		head = 0;
		tail = 0;
		length = 0;
	}
	
	//add item to tail of queue
	public void add (Object x)
	{
		tail = increment(tail);
		elements[tail] = x;
		length++;
	}
	
	//remove item from head of queue
	public Object remove()
	{
		length--;
		Object obj = elements[head];
		elements[head] = null;
		head = increment(head);
		return obj;
	}
	
	//get number of item in queue
	public int getLength()
	{
		return length;
	}
	
	//helper method to increment with wrap around
	private int increment (int x)
	{
		int r = x + 1;
		
		if (r == elements.length)
		{
			r = 0;
		}
		
		return r;
	}
}














