//Chapter 20 - Exercise 20.9

public class CircularArrayQueueTester
{
	public static void main (String[] args)
	{
		CircularArrayQueue c = new CircularArrayQueue(5);
		c.add(new Integer(1));
		c.add(new Integer(2));
		c.add(new Integer(3));
		c.add(new Integer(4));
		c.add(new Integer(5));
		
		while (c.getLength() > 0)
		{
			System.out.println(c.remove());
		}
	}
}