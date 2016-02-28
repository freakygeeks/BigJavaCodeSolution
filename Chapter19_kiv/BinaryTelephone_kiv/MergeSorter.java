//Chapter 19 - Exercise 19.5

public class MergeSorter
{
	private Item[] a;
	
	public MergeSorter(Item[] anItem)
	{
		a = anItem;
	}
	
	//sort array managed by this merge sorter
	public void sort (int from, int to)
	{
		if (from >= to)
		{
			return;
		}
		
		int mid = (from+to)/2;
		
		sort(from, mid);
		sort(mid+1, to);
		merge(from, mid, to);
	}
	
	//merge two sorted array into the array to be sorted by merge sorter
	private void merge (int from, int mid, int to)
	{
		int n = to-from+1;
		Item[] b = new Item[n];
		int n1 = from;
		int n2 = mid + 1;
		int j = 0;
		
		while (n1 <= mid && n2 <= to)
		{
			if (a[n1].getKey().compareTo(a[n2].getKey()) < 0)
			{
				b[j] = a[n1];
				n1++;
			}
			
			else
			{
				b[j] = a[n2];
				n2++;
			}
		}
		
		//copy remaining entry of the first half
		while (n1 <= mid)
		{
			b[j] = a[n1];
			n2++;
			j++;
		}
		
		//copy remaining entry of the second half
		while (n2 <= to)
		{
			b[j] = a[n2];
			n2++;
			j++;
		}
		
		//copy back from the temporary vector
		for (j = 0; j < n; j++)
		{
			a[from+j] = b[j];
		}
	}
	
	//sort array manage by this merge sorter
	public void sort()
	{
		if (a.length <= 1)
		{
			return;
		}
		
		Item[] first = new Item[a.length/2];
		Item[] second = new Item[a.length-first.length];
		
		System.arraycopy(a, 0, first, 0, first.length);
		System.arraycopy(a, first.length, second, 0, second.length);
		
		MergeSorter firstSorter = new MergeSorter(first);
		MergeSorter secondSorter = new MergeSorter(second);
		firstSorter.sort();
		secondSorter.sort();
		
		merge(first, second);
	}
	
	//merge two sorted array 
	private void merge (Item[] first, Item[] second)
	{
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while (iFirst < first.length && iSecond < second.length)
		{
			if (first[iFirst].getKey().compareTo(second[iSecond].getKey()) < 0)
			//if (a[iFirst].getKey().compareTo(a[iSecond].getKey()) < 0)
			{
				a[j] = first[iFirst];
				iFirst++;
			}
			
			else
			{
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		
		System.arraycopy(first, iFirst, a, j, first.length-iFirst);
		System.arraycopy(second, iSecond, a, j, second.length-iSecond);
	}
}