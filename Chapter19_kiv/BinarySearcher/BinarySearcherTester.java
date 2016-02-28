//Chapter 19 - Example 19.7

import java.util.Scanner;

public class BinarySearcherTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		BinarySearcher seacher = new BinarySearcher(a);
		
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while(!done)
		{
			System.out.print("Enter number to search for, -1 to quit : ");
			int n = in.nextInt();
			
			if (n == -1)
			{
				done = true;
			}
			
			else
			{
				int pos = seacher.search(n);
				System.out.println("Found in position " + pos);
			}
		}
	}
}