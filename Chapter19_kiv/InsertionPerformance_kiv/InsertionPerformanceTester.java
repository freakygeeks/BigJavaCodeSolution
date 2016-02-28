//Chapter 19 - Exercise 19.11

public class InsertionPerformanceTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		InsertionPerformance sorter = new InsertionPerformance(a);
		sorter.sort();
		ArrayUtil.print(a);
	}
}