//Chapter7 - Exercise P7.5

public class FibonacciSequence
{
	private int a;
	private int b;
	private int n;
	
	FibonacciSequence()
	{
	a = 0;
	b = 1;
	n = 0;
	}
	
	public void getSeq(int num)
	{
	n = n + num;
	
	if (n == 0)
		{
		System.out.println ("f0 = 0");
		}
	else if (n == 1)
		{
		System.out.println ("f0 = 0" + "\n" + "f1 = 1");
		}
	else
		{
		System.out.println ("f0 = 0" + "\n" + "f1 = 1");
		for (int i = 1; i < n; i++)
			{
			int count = i + 1;
			int nextNum = a + b;
			a = b;
			b = nextNum;
			System.out.println ("f" + count +" = " + nextNum);
			}
		}
	}
}
