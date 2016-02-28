//Chapter10 - Example 10.2

public class RootApproximatorHarness2 //test harness to get square root by increment the test number
{
	public static void main (String[] args)
	{
	final double MIN = 1;
	final double MAX = 10;
	final double INCREMENT = 0.5;
	for (double x = MIN; x <= MAX; x = x + INCREMENT)
		{
		RootApproximator r = new RootApproximator(x);
		double y = r.getRoot();
		System.out.println ("Square root of " + x + " = " + y);
		}
	}
}