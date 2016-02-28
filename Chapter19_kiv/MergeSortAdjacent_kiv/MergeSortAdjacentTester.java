//Chapter 19 - Exercise 19.9
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_9

import java.util.Arrays;

public class MergeSortAdjacentTester
{
	public static void main (String[] args)
	{
		int[] a = new int[16];
		for (int i = 0; i < 16; i++)
		{
			a[i] = 100 - (8-i) * (8-i);
		}
		
		MergeSortAdjacent sorter = new MergeSortAdjacent(a);
		sorter.sort();
		System.out.println(Arrays.toString(a));
		System.out.println("Expected: [36, 51, 51, 64, 64, 75, 75, 84, 84, 91, 91, 96, 96, 99, 99, 100]");
	}
}