//Chapter 23 - Example 23.1

import java.util.Date;

public class GreetingRunnable implements Runnable
{
	private String greeting;
	private static final int REPETITION = 10;
	private static final int DELAY = 1000;
	
	public GreetingRunnable(String aGreeting)
	{
		greeting = aGreeting;
	}
	
	public void run()
	{
		try
		{
			for (int i = 1; i <= REPETITION; i++)
			{
				Date now = new Date();
				System.out.println(now + " " + greeting);
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException exception)
		{
		}
	}
}