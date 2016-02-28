//Chapter7 - Exercise P7.14, http://en.wikipedia.org/wiki/E_(mathematical_constant), http://galileo.phys.virginia.edu/classes/152.mf1i.spring02/Exponential_Function.htm, http://en.wikipedia.org/wiki/Exponential_function, http://martin.ankerl.com/2007/02/11/optimized-exponential-functions-for-java/

public class ExpApproximator
{
	private double x;
	private double n;
	private double numerator;
	private double denominator;
	private double xold;
	private double xnew;
	private double sum;
	
	ExpApproximator(double aX)
	{
	x = aX;
	n = 100;
	numerator = 0;
	denominator = 1;
	xold = 0;
	xnew = 0;
	sum = 1;
	}
	
	public double getPowSeries()
	{
	
	for (int i = 1; i <= n; i++)
		{
		
		numerator = Math.pow(x,i);
		denominator = denominator*i;
		
		xold = numerator/denominator;
		xnew = xold;
		sum = sum + xnew;
		System.out.println("Term for factorial " + i + " = " + xnew);
		
		if (xold <= 0.00005)
			break;
		}
		return xnew;
	}
	
	public double getSum()
	{
	return sum;
	}
}