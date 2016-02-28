//Chapter 21 - Exercise 21.11

public class IntSetEratosthenesTester
{
	public static void main (String[] args)
	{
		IntSetEratosthenes s = new IntSetEratosthenes();
		int n = 100;
		
		for (int i = 2; i <= n; i++)
		{
			s.add(i);
		}
		
		for (int k = 2; k*k <= n; k++)
		{
			for (int i = 2; i*k <= n; i++)
			{
				s.remove(i*k);
			}
		}
		
		s.print();
	}
}