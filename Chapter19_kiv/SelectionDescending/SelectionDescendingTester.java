//Chapter 19 - Exercise 19.1

public class SelectionDescendingTester
{
	public static void main (String[] args)
	{
		int[] a = ArrayUtil.randomIntArray(20, 100);
		ArrayUtil.print(a);
		
		SelectionDescending s = new SelectionDescending(a);
		s.sort();
		
		ArrayUtil.print(a);
	}
}