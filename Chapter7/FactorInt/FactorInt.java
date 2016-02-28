//Chapter7 - Exercise P7.10

public class FactorInt
{
	private int n;
	
	FactorInt()
	{
	n = 0;
	}
	
	public void getFactor(int num)
	{
	n = n + num;
	
	for (int i = 2; i < n; i++) // must always start with number 2
		{
		while (n % i == 0) // the remainder when dividing number with i result to zero
			{
			n = n / i; //num divide by i
			System.out.print ("Factor by " + i + "\n" );
			}
		}
	if (n > 1)
		{
		System.out.println ("Factor by " + n);
		}
	else
		System.out.println();
	}
}