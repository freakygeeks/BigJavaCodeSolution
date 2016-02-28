//Chapter 23 - Exercise 23.1

public class ConsumerThread extends Thread
{
	private Queue queue = null;
	private int count;
	private static final int DELAY = 1000;
	
	public ConsumerThread (Queue aQueue, int aCount)
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
				System.out.println("Consumer : " + queue.remove());
				sleep(DELAY);
			}
		}
		catch (InterruptedException exception)
		{
		}
	}
}