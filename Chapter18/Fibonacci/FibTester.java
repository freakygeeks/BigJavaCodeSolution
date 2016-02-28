//Chapter 18 - Example 18.4

import java.util.Scanner;

public class FibTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = in.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			long f = fib(i);
			System.out.println("fib(" + i + ") = " + f);
		}
	}
	
	public static long fib(int n)
	{
		if (n <= 2)
		{
			return 1;
		}
		
		else 
		{
			return fib(n-1) + fib(n-2);
		}
	}
}