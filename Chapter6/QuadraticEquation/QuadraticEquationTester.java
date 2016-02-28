//Chapter6 - Exercise P6.1
import java.util.Scanner;

public class QuadraticEquationTester
{
	public static void main (String[] args)
	{
	QuadraticEquation calc = new QuadraticEquation();
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Please enter the first coefficients value 'a' :");
	double a = in.nextDouble();
	
	System.out.print ("Please enter the second coefficients value 'b' :");
	double b = in.nextDouble();
	
	System.out.print ("Please enter the third coefficients value 'c' : ");
	double c = in.nextDouble();
	
	calc.getValue(a,b,c);
	
	System.out.println("Discriminant value is : " + calc.getDiscriminant());
	System.out.println("Boolean value is : " + calc.hasSolution());
	
	if (calc.hasSolution() == true)
		System.out.println ("Yay! They have solution.." + "\n" + "First solution value is : " + calc.getSolutionOne() + "\n" + "Second solution value is : " + calc.getSolutionTwo());
	else 
		System.out.println ("Nay! No solution for this..");
	}
}