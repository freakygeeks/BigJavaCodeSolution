//Chapter 23 - Example 23.1

import java.util.Date;

public class GreetingThreadTester
{
	public static void main (String[] args)
	{
		GreetingRunnable r1 = new GreetingRunnable("Hello world!");
		GreetingRunnable r2 = new GreetingRunnable("Goodbye world!");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}