//Chapter 21 - Exercise 21.9

public class IntSetTester
{
	public static void main (String[] args)
	{
		IntSet s = new IntSet();
		s.add(2);
		s.add(3);
		s.add(5);
		s.add(7);
		s.add(9);
		s.add(7);
		s.remove(9);
		
		IntSetIterator iterator = s.intSetIterator();
		
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}























