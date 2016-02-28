//Chapter 19 - Example Advanced Topic 19.1

public class InsertionSorter
{
	private int[] a;
	
	public InsertionSorter(int[] anArray)
	{
		a = anArray;
	}
	
	public void sort()
	{
		for (int i = 1; i < a.length; i++)
		{
			int next = a[i];
			int j = i;
			
			while (j > 0 && a [j-1] > next)
			{
				a[j] = a[j-1];
				j--;
			}
			a[j] = next;
		}
	}
}