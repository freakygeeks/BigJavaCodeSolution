//Chapter 19 - Example 19.4

public class MergeSorter
{
	private int[] a;
	
	public MergeSorter(int[] anArray)
	{
		a = anArray;
	}
	
	//sort array managed by merge sorter
	public void sort()
	{
		if (a.length <= 1)
		{
			return;
		}
		
		int[] first = new int[a.length/2];
		int[] second = new int[a.length-first.length];
		
		System.arraycopy(a, 0, first, 0, first.length);
		System.arraycopy(a, first.length, second, 0, second.length);
		
		MergeSorter firstSorter = new MergeSorter(first);
		MergeSorter secondSorter = new MergeSorter(second);
		
		firstSorter.sort();
		secondSorter.sort();
		merge(first, second);
	}
	
	//merge two sorted array into array managed by merge sorter
	public void merge(int[] aFirst, int[] aSecond)
	{
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while (iFirst < aFirst.length && iSecond < aSecond.length)
		{
			if (aFirst[iFirst] < aSecond[iSecond])
			{
				a[j] = aFirst[iFirst];
				iFirst++;
			}
			
			else
			{
				a[j] = aSecond[iSecond];
				iSecond++;
			}
			
			j++;
		}
		
		System.arraycopy(aFirst, iFirst, a, j, aFirst.length-iFirst);
		System.arraycopy(aSecond, iSecond, a, j, aSecond.length-iSecond);
	}
}




