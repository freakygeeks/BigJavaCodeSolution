//Chapter 9 - Exercise 9.7

import java.awt.geom.Ellipse2D;

public class EllipseHelper
{
	public static double perimeter (Ellipse2D.Double e)
	{
		double a = e.getWidth()/2;
		double b = e.getHeight()/2;
		
		return Math.PI*(1.5*(a+b)-Math.sqrt(a*b));
	}
	
	public static double area (Ellipse2D.Double e)
	{
		double a = e.getWidth()/2;
		double b = e.getHeight()/2;
		
		return Math.PI*a*b;
	}
}