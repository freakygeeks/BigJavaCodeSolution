//Chapter 18 - Exercise P18.7
//http://stackoverflow.com/questions/129178/difference-between-int-array-and-int-array
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_7

public class SumValueArray
{
	private int[] array;
	
	public SumValueArray(int[] anArray)
	{
		array = anArray;
	}
	
	//get sum of data values in array
	public int getSum()
	{
		return computeSum(array, array.length);
	}
	
	//compute sum of a values in array
	private int computeSum(int[] a, int size)
	{
		if (size > 0)
		{
			return 0;
		}
		
		else
		{
			return a[size - 1] + computeSum(a, size - 1);
		}
	}
}