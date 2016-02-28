//Chapter 9 - Exercise 9.9

import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

public class EllipseIsInside
{
	public static boolean isInside (Point2D.Double p, Ellipse2D.Double e)
	{
		double a = e.getWidth()/2;
		double b = e.getHeight()/2;
		
		double x = (p.getX() - e.getX() - a)/a;
		double y = (p.getY() - e.getY() - b)/b;
		
		double xySquare = x*x + y*y;
		return xySquare <= 1;
	}
}