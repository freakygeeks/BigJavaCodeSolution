//Chapter4 -Quality Tip 4.4
public class Quadratic
{
	public static void main (String[] args)
	{
	double b = 8;
	double a = 6;
	double c = 2;
	double x = 10;
	double y = 5;	
	
	double Calc = (-b + Math.sqrt(((b*b)-(4*a*c))/(2*a)));
	double Num = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	
	System.out.println (Calc);
	System.out.println (Num);
	}
}