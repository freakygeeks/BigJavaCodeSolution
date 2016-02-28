//http://stackoverflow.com/questions/24789191/beginners-java-code-help-newton-raphson-square-root-loop, http://www.shodor.org/unchem/math/newton/

import java.text.NumberFormat; 
import java.text.DecimalFormat; 

public class NewtonRaphson 
{
	static final double DIFFERENCE = 0.00005; 
	double n; 
	double x; 
	double derivative; 
	double function; 
	double xold; 
	double xnew; 
	int i; 

public NewtonRaphson(double n2, int x2) 
	{ 
    n=n2; 
	System.out.println ("n value : " + n);
    x=x2; 
	System.out.println ("x value : " + x);
    function = Math.pow(n, 2)-x; 
	System.out.println ("function value : " + function);
    derivative = 2*n; 
	System.out.println ("derivative value : " + derivative);
    xnew=n-function/derivative; 
	System.out.println ("xnew value : " + xnew);
    xold=0; 
	} 

/*boolean positive() 

{ 
    return (n >= 0); 
} */

public double findXNew(double xold2) 
	{ 
    function = Math.pow(xold2, 2)-x; 
	System.out.println ("function value in findXNew : " + function);
    derivative = 2*xold2; 
	System.out.println ("derivative value in findXNew : " + derivative);
	double cuba = xold2-function/derivative;
	System.out.println ("xold2-function/derivative value : " + cuba);
    return xold2-function/derivative; 
	} 

public void findSqRtA() 
	{ 
    i=0; 
    while(Math.abs(xnew-xold)> DIFFERENCE)
		{ 
		xold=xnew; 
		xnew=findXNew(xold); 
		System.out.println(this); 
		} 
    
		System.out.println("\nIteration completed, difference is less than 0.00005"); 
	} 

public String toString() 
	{ 
    NumberFormat nf = NumberFormat.getInstance(); DecimalFormat df = (DecimalFormat)nf; 
    df.applyPattern("0.00000000"); 

    return "The approximate value of the square root of "+x+" is " + xnew + "\n" + 
    "The number of iterations is " + i; 
	} 
}