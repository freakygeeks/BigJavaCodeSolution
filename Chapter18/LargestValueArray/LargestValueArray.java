//Chapter 18 - Exercise P18.6
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_6

public class LargestValueArray
{
	private int[] values;
	
	public LargestValueArray(int[] aValues)
	{
		values = aValues;
	}
	
	public int getMax()
	{
		return computeMax(values, values.length);
	}
	
	public int computeMax(int[] a, int size)
	{
		if (size > 0)
		{
			return Math.max(a[size-1], computeMax(a, size-1));
		}
		
		else
		{
			return a[0];
		}
	}
}