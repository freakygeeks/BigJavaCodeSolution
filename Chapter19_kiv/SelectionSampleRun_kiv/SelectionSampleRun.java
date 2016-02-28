//Chapter 19 - Exercise 19.3
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_3

public class SelectionSampleRun
{
	private int[] a;
	
	public SelectionSampleRun(int[] anArray)
	{
		a = anArray;
	}
	
	public void sort()
	{
		for (int i = 0; i < a.length-1; i++)
		{
			int minPos = minimumPosition(i);
			swap(minPos, i);
		}
	}
	
	//find smallest element in array
	public int minimumPosition (int from)
	{
		int minPos = from;
		
		for (int i = from+1; i < a.length; i++)
		{
			if (a[i] < a[minPos])
			{
				minPos = i;
			}
		}
		
		return minPos;
	}
	
	//swap two entries of array
	private void swap (int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}















