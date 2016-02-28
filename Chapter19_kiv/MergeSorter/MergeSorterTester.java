//Chapter 19 - Example Topic 19.4

public class MergeSorterTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		MergeSorter sorter = new MergeSorter(a);
		sorter.sort();
		
		ArrayUtil.print(a);
	}
}