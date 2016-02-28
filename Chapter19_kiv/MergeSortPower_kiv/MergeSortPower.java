//Chapter 19 - Exercise 19.10
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_10

public class MergeSortPower
{
	private int[] a;
	
	public MergeSortPower(int[] anArray)
	{
		a = anArray;
	}
	
	//sort array
	public void sort()
	{
		int length = 1;
		
		while (length <= a.length)
		{
			int start = 0;
			
			while (start+2*length <= a.length)
			{
				merge(start, start+length-1, start+2*length-1);
				start = start+2*length;
			}
			
			if (start+length <= a.length)
			{
				merge(start, start+length-1, a.length-1);
			}
			
			length = length*2;
			start = 0;
		}
	}
	
	public void merge (int from, int mid, int to)
	{
		int n = to-from+1;
		int[] b = new int[n];
		
		int n1 = from;
		int n2 = mid+1;
		int j = 0;
		
		while (n1 < mid && n2 <= to)
		{
			if (a[n1] < a[n2])
			{
				b[j] = a[n1];
				n1++;
			}
			
			else
			{
				b[j] = a[n2];
				n2++;
			}
			
			j++;
		}
		
		//copy any remaining entry of first half
		while (n1 <= mid)
		{
			b[j] = a[n1];
			n1++;
			j++;
		}
		
		//copy any remaining entry of second half
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
}











