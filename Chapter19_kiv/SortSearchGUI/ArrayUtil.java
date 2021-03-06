//Chapter 19 - Project 19.2

import java.util.Random;

public class ArrayUtil
{
	private static Random gen = new Random();
	
	//create an array filled with random values
	public static int[] randomIntArray (int length, int n)
	{
		int[] a = new int[length];
		
		for (int i = 0; i < a.length; i++)
		{
			a[i] = gen.nextInt(n);
		}
		
		return a;
	}
	
	//prints all elements in an array
	public static void print (int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
	}
}