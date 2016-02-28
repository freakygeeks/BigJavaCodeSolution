//Chapter 19 - Exercise 19.1
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_1

public class SelectionDescending
{
	private int[] a;
	
	public SelectionDescending(int[] anArray)
	{
		a = anArray;
	}
	
	//sort array managed by selection sorter
	public void sort()
	{
		for (int i = 0; i < a.length-1; i++)
		{
			int maxPos = maximumPosition(i);
			
			if (maxPos != i)
			{
				swap (maxPos, i);
			}
		}
	}
	
	//find largest element in array range
	public int maximumPosition(int from)
	{
		int maxPos = from;
		
		for (int i = from+1; i < a.length; i++)
		{
			if (a[i] > a[maxPos])
			{
				maxPos = i;
			}
		}
		
		return maxPos;
	}
	
	//swap two entries of an array
	public void swap (int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}