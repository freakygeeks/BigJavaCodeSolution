//Chapter 19 - Example Advanced Topic 19.1

public class InsertionSorterTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		InsertionSorter sorter = new InsertionSorter(a);
		sorter.sort();
		
		ArrayUtil.print(a);
	}
}