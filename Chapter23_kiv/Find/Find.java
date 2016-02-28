//Chapter 23 - Exercise 23.7

public class Find
{
	public static void main (String[] args)
	{
		for (int i = 1; i < args.length; i++)
		{
			new FindThread(args[0], args[i]).start();
		}
	}
}