//Chapter4 - Project 4.1
import java.util.Scanner;

public class TriangleTester
{
	public static void main (String[] args)
	{
	Triangle calc = new Triangle();
	Scanner in = new Scanner (System.in);
	
	System.out.println ("\n" +"===================================================================" + "\n");
	System.out.println ("Please enter your first corner point coordinates for triangle");
	double x1 = in.nextDouble();
	double y1 = in.nextDouble();
	
	System.out.println ("Please enter your second corner point coordinates for triangle");
	double x2 = in.nextDouble();
	double y2 = in.nextDouble();	
	
	System.out.println ("Please enter your third corner point coordinates for triangle");
	double x3 = in.nextDouble();
	double y3 = in.nextDouble();
	
	calc.getFirstCorner(x1,y1);
	calc.getSecondCorner(x2,y2);
	calc.getThirdCorner(x3,y3);
	
	System.out.println ("\n" +"===================================================================" + "\n");
	System.out.println ("The first triangle side length is : " + calc.getFirstLength());
	System.out.println ("The second triangle side length is : " + calc.getSecondLength());
	System.out.println ("The third triangle side length is : " + calc.getThirdLength());
	
	calc.getLargestLength();
	
	System.out.println ("\n" +"===================================================================" + "\n");
	System.out.println ("The first largest triangle angle is : " + calc.getFirstLargestAngle());
	System.out.println ("The second largest triangle angle is : " + calc.getSecondLargestAngle());
	System.out.println ("The third largest triangle angle is : " + calc.getThirdLargestAngle());	
	
	System.out.println ("\n" +"===================================================================" + "\n");
	System.out.println ("The triangle perimeter is : " + calc.getPerimeter());
	
	System.out.println ("\n" +"===================================================================" + "\n");
	System.out.println ("The triangle area is : " + calc.getArea());
	}
}