//Chapter 23 - Exercise 23.1

import java.util.Date;

public class ProducerThread extends Thread
{
	private Queue queue = null;
	private int count;
	private static final int DELAY = 1000;
	
	public ProducerThread (Queue aQueue, int aCount)
	{
		count = aCount;
		queue = aQueue;
	}
	
	public void run()
	{
		try
		{
			for (int i = 0; i < count && !isInterrupted(); i++)
			{
				String item = new Date().toString();
				System.out.println("Producer : " + item);
				queue.add(item);
				sleep(DELAY);
			}
		}
		catch (InterruptedException exception)
		{
		}
	}
}