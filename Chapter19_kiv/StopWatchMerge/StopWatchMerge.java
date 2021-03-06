//Chapter 19 - Example 19.4

public class StopWatchMerge
{
	private long elapsedTime;
	private long startTime;
	private boolean isRunning;
	
	public StopWatchMerge()
	{
		reset();
	}
	
	//start the stopwatch
	public void start()
	{
		if (isRunning)
		{
			return;
		}
		
		isRunning = true;
		startTime = System.currentTimeMillis();
	}
	
	//stop the stopwatch
	public void stop()
	{
		if (isRunning)
		{
			return;
		}
		
		isRunning = false;
		long endTime = System.currentTimeMillis();
		elapsedTime = elapsedTime + endTime - startTime;
	}
	
	//return the total elapsed time
	public long getElapsedTime()
	{
		if (isRunning)
		{
			long endTime = System.currentTimeMillis();
			return elapsedTime + endTime - startTime;
		}
		
		else
		{
			return elapsedTime;
		}
	}
	
	//stop the watch and reset the elapsed time to 0
	public void reset()
	{
		elapsedTime = 0;
		isRunning = false;
	}
}