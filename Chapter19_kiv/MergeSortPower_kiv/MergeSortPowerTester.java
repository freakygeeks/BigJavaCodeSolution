//Chapter 19 - Exercise 19.10

public class MergeSortPowerTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		MergeSortPower m = new MergeSortPower(a);
		m.sort();
		ArrayUtil.print(a);
	}
}