//Chapter7 - Exercise P7.12 - http://www.iro.umontreal.ca/~pift1025/bigjava/Ch10/ch10.htm, http://mathforum.org/library/drmath/view/52609.html, http://horstmann.com/javabrat/ExP7_12.html,http://www.mathcs.emory.edu/~cheung/Courses/170.2010/Syllabus/Decisions/compare-floats.html

/**Computes approximations to the square root of a number, using Heron's algorithm.*/
public class HeronApproximator
{
	private double a; // The number whose square root is computed
	private double xnew; // The current guess
	private double xold; // The old guess
	
/**Constructs a root approximator for a given number.@param aNumber the number from which to extract the square root.(Precondition: aNumber >= 0)*/
	public HeronApproximator(double aNumber)
	{
	a = aNumber; // a is user input num
	xold = 1; //define num 1, this can be any number
	xnew = a; //replace with user input num
	}

/**Computes a better guess from the current guess.@return the next guess*/
	public double nextGuess()
	{
	xold = xnew; //1 will be replace with user input num and new value of xnew
	//System.out.print("o " + xold + " "); 
	if (xold != 0) //user input num is not equal to zero
	xnew = (xold + a / xold) / 2; //calculation for heron square root
	//System.out.print("n " +xnew + " ");
	return xnew; //return new value for xnew for (heron square root value)
	}
	
/**Computes the root by repeatedly improving the current guess until two successive guesses are approximately equal. @return the computed value for the square root*/
	public double getRoot()
	{
	//assert a >= 0;
	while (!HeronApproximatorNumeric.approxEqual(xnew, xold)) //called class to compare approximation value xnew and xold, is almost the same up to 10 decimal
	nextGuess(); //loop the nextGuess() assessor method until equal 10 decimal point
	return xnew; //return value of same xold and xnew
	}
}