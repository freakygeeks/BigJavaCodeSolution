//Chapter 19 - Exercise 19.3

import java.util.Random;

public class ArrayUtil
{
	//create array filled with random values
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
	
	//print all elements in an array
	public static void print(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}