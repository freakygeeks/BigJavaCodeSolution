//Chapter10 - Example 10.1

public class RootApproximator
{
	private double a;
	private double xnew;
	private double xold;
	
	public RootApproximator(double aNumber) //get the number input
	{
	a = aNumber;
	xold = 1;
	xnew = a;
	}
	
	public double nextGuess() //compute for better guess from current guess, this is the calculation
	{
	xold = xnew;
	if (xold != 0)
		{
		xnew = (xold + a / xold) / 2;
		}
	return xnew;
	}
	
	public double getRoot() //until two successive guesses are approximately equal
	{
	assert a >= 0;
	while (!Numeric.approxEqual(xnew, xold)) //calling the static method in Numeric.java
		{
		nextGuess();
		}
	return xnew;
	}
	
}