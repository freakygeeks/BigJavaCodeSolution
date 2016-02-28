//Chapter 19 - Example 19.1

public class SelectionSorterTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		SelectionSorter sorter = new SelectionSorter(a);
		sorter.sort();
		
		ArrayUtil.print(a);
	}
}