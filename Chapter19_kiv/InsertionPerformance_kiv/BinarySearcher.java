//Chapter 19 - Exercise 19.11

public class BinarySearcher
{
	private int[] a;
	
	public BinarySearcher(int[] anArray)
	{
		a = anArray;
	}
	
	public int search (int v, int high)
	{
		int low = 0;
		
		while (low <= high)
		{
			int mid = (low+high)/2;
			int diff = a[mid]-v;
			
			if (diff == 0)
			{
				return mid;
			}
			
			else if (diff < 0)
			{
				low = mid + 1;
			}
			
			else
			{
				high = mid - 1;
			}
		}
		
		return -low-1;
	}
}