//Chapter 23 - Exercise 23.1

import java.util.ArrayList;

public class Queue
{
	private ArrayList queue;
	private int size = 0;
	private static final int DEFAULT_SIZE = 10;
	
	public Queue()
	{
		size = DEFAULT_SIZE;
		queue = new ArrayList(size);
	}
	
	public Queue (int aSize)
	{
		size = aSize;
		queue = new ArrayList(size);
	}
	
	//add string into queue
	public synchronized void add (String item) throws InterruptedException
	{
		while (isFull())
		{
			wait();
		}
		
		queue.add(item);
		notifyAll();
	}
	
	//remove one item from queue
	public synchronized String remove() throws InterruptedException
	{
		while (isEmpty())
		{
			wait();
		}
		
		notifyAll();
		return queue.remove(0).toString();
	}
	
	//check if queue is empty
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	//check if queue is full
	public boolean isFull()
	{
		return queue.size() == size;
	}
}























