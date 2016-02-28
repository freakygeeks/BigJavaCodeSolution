//Chapter 19 - Exercise 19.8
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_8

public class BinaryPositionTester
{
	public static void main (String[] args)
	{
		int[] a = new int[10];
		
		for (int i = 0; i < 10; i++)
		{
			a[i] = i*i;
		}
		
		BinaryPosition pos = new BinaryPosition(a);
		
		System.out.println(searcher.search(4));
		System.out.println("Expected: 2");
		
		System.out.println(searcher.search(81));
		System.out.println("Expected: 9");
		
		System.out.println(searcher.search(0));
		System.out.println("Expected: 0");
		
		System.out.println(searcher.search(3));
		System.out.println("Expected: -3");
		
		System.out.println(searcher.search(-1));
		System.out.println("Expected: -1");
		
		System.out.println(searcher.search(100));
		System.out.println("Expected: -11");

	}
}