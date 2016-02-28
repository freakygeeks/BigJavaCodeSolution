//Chapter7 - Exercise P7.12

/**A class for useful numeric methods.*/
public class HeronApproximatorNumeric
{  
/**Tests whether two floating-point numbers are equal, except for a roundoff error @param x a floating-point number @param y a floating-point number @return true if x and y are approximately equal */
	public static boolean approxEqual(double x, double y) //using boolean for epsilon
	{  
	final double EPSILON = 1E-12; //define epsilon 1*10^12, e equals to 10, - equals to ^, meaning up to 10 decimal
	return Math.abs(x - y) <= EPSILON;//compare value x and y if it same using absolute 
	}
}