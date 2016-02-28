//Chapter3 - Exercise P3.10
public class CalcSquareTester
{
	public static void main (String[] args)
	{
	CalcSquare value = new CalcSquare();
	value.addAreaPerimeter (8);
	
	double newValue1 = value.getArea();
	double newValue2 = value.getPerimeter();
	
	System.out.println ("The square area is : " + newValue1 + " " + "and the square perimeter is : " + newValue2);
	}
}
	