//Chapter4 - Exercise P4.8
import java.util.Scanner;

public class CircleSphereTester
{
	public static void main (String[] args)
	{
	Circle cir = new Circle();
	Sphere sph = new Sphere();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter the radius value : ");
	double val = in.nextDouble();
	
	cir.insert(val);
	sph.insert(val);
	
	System.out.println ("The value of circle area is : " + cir.getArea());
	System.out.println ("The value of circle circumference is : " + cir.getCircumference());
	System.out.println ("The value of sphere volume is : " + sph.getVolume());
	System.out.println ("The value of sphere surface is : " + sph.getSurface());
	}
}