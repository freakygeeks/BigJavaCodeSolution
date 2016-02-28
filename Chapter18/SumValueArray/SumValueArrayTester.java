//Chapter 18 - Exercise P18.7

import java.util.Random;

public class SumValueArrayTester
{
	public static void main (String[] args)
	{
		Random gen = new Random();
		int capacity = 10; 
		int[] array = new int[capacity]; //declare capacity for array is only 10
		
		for (int i = 0; i < array.length; i++)
		{
			int num = gen.nextInt(10); //get random number between 0 until 10
			array[i] = num; //put the number into the array starting with array [0] until [9]
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		SumValueArray calc = new SumValueArray(array);
		System.out.println("Sum = " + calc.getSum());
	}
}