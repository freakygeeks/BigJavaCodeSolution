//Chapter 19 - Example Advanced Topic 19.3

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
		for (int e : a)
		{
			System.out.print(e + " ");
		}
		
		System.out.println();
	}
}