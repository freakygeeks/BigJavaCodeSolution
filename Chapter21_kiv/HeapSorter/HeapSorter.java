//Chapter 21 - Example 21.10

public class HeapSorter
{
	private int[] a;
	
	public HeapSorter(int[] anArray)
	{
		a = anArray;
	}
	
	//sort array managed by this heap sorter
	public void sort()
	{
		int n = a.length - 1;
		for (int i = (n-1)/2; i >= 0; i--)
		{
			fixHeap(i, n);
		}
		
		while (n > 0)
		{
			swap (0, n);
			n--;
			fixHeap(0, n);
		}
	}
	
	//ensures heap property for subtree, provided children already fulfill heap property
	private void fixHeap(int rootIndex, int lastIndex)
	{
		//remove root
		int rootValue = a[rootIndex];
		
		//promote children while they are larger than root
		int index = rootIndex;
		boolean more = true;
		while (more)
		{
			int childIndex = getLeftChildIndex(index);
			if (childIndex <= lastIndex)
			{
				//use right child instead if it is larger
				int rightChildIndex = getRightChildIndex(index);
				if (rightChildIndex <= lastIndex && a[rightChildIndex] > a[childIndex])
				{
					childIndex = rightChildIndex;
				}
				
				if (a[childIndex] > rootValue)
				{
					//promote child
					a[index] = a[childIndex];
					index = childIndex;
				}
				
				else
				{
					//root value larger than both children
					more = false;
				}
			}
			
			else
			{
				//no children
				more = false;
			}
		}
		
		//store root value in vacant slot
		a[index] = rootValue;
	}
	
	//swap two entries of the array
	private void swap (int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//return index of left child
	private static int getLeftChildIndex (int index)
	{
		return 2*index+1;
	}
	
	//return index of right child
	private static int getRightChildIndex (int index)
	{
		return 2*index+2;
	}
}













