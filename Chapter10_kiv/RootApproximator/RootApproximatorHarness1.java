//Chapter10 - Example 10.2

public class RootApproximatorHarness1 //test harness to get square root by defining an array of test number
{
	public static void main (String[] args)
	{
	double[] testInputs = {100, 4, 2, 1, 0.25, 0.01};
	for (double x : testInputs)
		{
		RootApproximator r = new RootApproximator(x);
		double y = r.getRoot();
		System.out.println ("Square root of " + x + " = " + y);
		}
	}
}