//Chapter3 - Exercise P3.9
public class CalcCircleTester
{
	public static void main (String[] args)
	{
	CalcCircle calc = new CalcCircle();
	calc.addArea (270, 4);
	calc.addPerimeter (4);
	
	double newArea = calc.getArea();
	double newPerimeter = calc.getPerimeter();
	
	System.out.println ("The area of circle is : " + newArea + 
	" " + "and the perimeter or circle is : " + newPerimeter);
	}
}