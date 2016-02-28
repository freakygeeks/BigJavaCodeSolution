//Chapter7 - Exercise P7.13

public class NewtonRaphsonApproximatorNumeric
{
	public static boolean approxEqual(double xnew, double xold)
	{
	final double EPSILON = 1E-12;//0.00005;
	return Math.abs(xnew - xold) <= EPSILON;
	}
}