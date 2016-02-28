//Chapter7 - Exercise P7.11 - http://www.programmingsimplified.com/java/source-code/java-program-print-prime-numbers

public class PrimeNum
{
	private int n;
	
	PrimeNum()
	{
	n = 0;
	}
	
	public void getPrime(int num)
	{
	n = n + num;
	
	for (int i = 2; i <= n; i++)//calculate from 2 for first loop
		{
		boolean prime = true; //if boolean is true, proceed to second loop
		
		for (int j = 2; j < i; j++) //calculate from 2 for second loop
			{
	
			if (i % j == 0) //if first loop num divide by num in second loop and get remainder of zero
				{
				prime = false; //boolean result is for remainder non zero
				break; // repeat the loop again
				}
			}
		if(prime) //if boolean prime is true
			System.out.print ("Prime number : " + i + "\n"); //this is the output
		}
		
	/*boolean prime2 = true;
	while(prime2)
		{
		for (int k = 2; k <= n; k++)
		{
			for (int h = 2; h < k; h++)
			{
			if (k % h == 0)
				{
				prime2 = false;
				System.out.print (k + "\n");
				}
			else
				{
				break;
				}
			}
		}
		}*/
	}
}