//Chapter 19 - Exercise 19.11
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_11

public class InsertionPerformance
{
	private int[] a;
	private BinarySearcher s;
	
	public InsertionPerformance(int[] anArray)
	{
		a = anArray;
	}
	
	public void sort()
	{
		int[] b = new int[a.length];
		BinarySearcher s = new BinarySearcher(b);
		int j;
		
		for (int i = 0; i < a.length; i++)
		{
			int index = s.search(a[i], i-1);
			
			if (index < 0)
			{
				index = -index-1;
			}
			
			for (j = i; j < index; j--)
			{
				b[j] = b[j-1];
			}
			
			b[j] = a[i];
		}
		
		System.arraycopy(b, 0, a, 0, a.length);
	}
}
