//Chapter 19 - Example Advanced Topic 19.3

public class QuickSorterTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		QuickSorter sorter = new QuickSorter(a);
		sorter.sort(0, 19);
		
		ArrayUtil.print(a);
	}
}