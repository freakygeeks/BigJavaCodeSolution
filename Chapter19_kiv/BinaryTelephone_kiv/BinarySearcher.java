//Chapter 19 - Exercise 19.5

public class BinarySearcher
{
	private Item[] v;
	
	public BinarySearcher(Item[] anItem)
	{
		v = anItem;
	}
	
	public int binarySearch (int from, int to, String a)
	{
		if (from > to)
		{
			return -1;
		}
		
		int mid = (from + to)/2;
		int diff = v[mid].getKey().compareTo(a);
		
		if (diff == 0)
		{
			return mid;
		}
		
		else if (diff < 0)
		{
			return binarySearch(mid+1, to, a);
		}
		
		else
		{
			return binarySearch(from, mid-1, a);
		}
	}
}