//Chapter 19 - Example 19.1

public class SelectionSorter
{
	private int[] a;
	
	public SelectionSorter(int[] anArray)
	{
		a = anArray;
	}
	
	//sort array managed by selection sorter
	public void sort()
	{
		for (int i = 0; i < a.length-1; i++)
		{
			int minPos = minimumPosition(i);
			swap(minPos, i);
		}
	}
	
	//find the smallest element in a tail range of array
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
























