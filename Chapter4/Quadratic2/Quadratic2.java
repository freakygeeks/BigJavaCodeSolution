//Chapter4
public class Quadratic2
{
	public static void main (String[] args)
	{
	double b = 8;
	double a = 6;
	double c = 2;
	
	double root = Math.sqrt((b*b)+(4*a*c));
	double x1 = (-b + root)/(2*a);
	double x2 = (-b - root)/(2*a);
	
	System.out.println (x1 + " and " + x2);
	}
}