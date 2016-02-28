//Chapter 18 - Exercise P18.6

import java.util.Random;

public class LargestValueArrayTester
{
	public static void main (String[] args)
	{
		Random gen = new Random();
		int capacity = 10;
		int[] values = new int[capacity];
		
		for (int i = 0; i < values.length; i++)
		{
			int num = gen.nextInt(300);
			values[i] = num;
			System.out.print(values[i] + " ");
		}
		
		System.out.println();
		LargestValueArray calc = new LargestValueArray(values);
		System.out.println("Maximum : " + calc.getMax());
	}
}