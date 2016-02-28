//Chapter7 - Exercise P7.13

public class NewtonRaphsonApproximator
{
	private double n;
	private double x;
	private double func;
	private double der;
	private double xold;
	private double xnew;
	private double xold2;
	
	public NewtonRaphsonApproximator(double aN, double aX) //for n = 5 and x = 5
	{
	n = aN;
	x = aX;
	func = 0;
	der = 0;
	xold = n;
	xnew = 0;
	}
	
	public double getGuess()
	{
	func = Math.pow(xold,2)-x;	//System.out.println ("function : " + func);
	der = 2*xold;				//System.out.println ("derivative : " + der);
	xnew = xold - func/der;		//System.out.println ("xnew : " + xnew);
	xold = xnew;				//System.out.println ("xold : " + xold);
	
	if (xold != 0)
		func = Math.pow(xold,2)-x;
		der = 2*xold;
		xnew = xold - func/der;	
		System.out.println ("Approximate square root value of  "+x+" is : " + xnew);
		return xnew;
	}
	
	public double getRoot()
	{
	while (!NewtonRaphsonApproximatorNumeric.approxEqual(xnew, xold))
		getGuess();
		//System.out.println ("Approximate " + xnew);
		return xnew;
	}
}
	