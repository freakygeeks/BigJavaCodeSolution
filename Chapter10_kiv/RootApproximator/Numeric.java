//Chapter10 - Example 10.1

public class Numeric // to test two floating point number are equal
{
	public static boolean approxEqual (double x, double y)	 // this is static method or class method, is a method that does not operate on an object and that has only explicit parameters
	{
	final double EPSILON = 1E-12;
	return Math.abs(x - y) <= EPSILON;
	}

}