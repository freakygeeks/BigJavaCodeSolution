//Chapter6 -  Exercise 6.5
import java.util.Scanner;

public class CubakiraTester
{
	public static void main (String[] args)
	{
	Cubakira calc = new Cubakira();
	Scanner in = new Scanner (System.in);
		
	System.out.println ("Enter number:");
	double a = in.nextDouble();
	double b = in.nextDouble();
	
	calc.enterNum(a, b);
	
	System.out.println ("Answer:");
	System.out.println(calc.getOrder());
	}
}