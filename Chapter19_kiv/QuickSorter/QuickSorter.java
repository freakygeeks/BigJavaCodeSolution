//Chapter 19 - Example Advanced Topic 19.3

public class QuickSorter
{
	private int[] a;
	
	public QuickSorter(int[] anArray)
	{
		a = anArray;
	}
	
	public void sort(int from, int to)
	{
		if (from >= to)
		{
			return;
		}
		
		int p = partition(from, to);
		sort(from, p);
		sort(p+1, to);
	}
	
	private int partition(int aFrom, int aTo)
	{
		int pivot = a[aFrom];
		int i = aFrom-1;
		int j = aTo+1;
		
		while (i < j)
		{
			i++;
			while(a[i] < pivot)
			{
				i++;
			}
			
			j--;
			while(a[j] > pivot)
			{
				j--;
			}
			
			if (i < j)
			{
				swap(i,j);
			}
		}
		return j;
	}
	
	//swap two entries of array
	private void swap (int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}