//Chapter 23 - Exercise 23.11

import java.util.Random;

public class ArrayUtil
{
	public static int[] randomIntArray (int length, int n)
	{
		int[] a = new int[length];
		Random gen = new Random();
		
		for (int i = 0; i < a.length; i++)
		{
			a[i] = gen.nextInt(n);
		}
		
		return a;
	}
	
	public static void swap (int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void print (int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}