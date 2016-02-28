//Chapter11 - Exercise P11.14

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle
{
	private double xLeft;
	private double yTop;
		
	public Rectangle(double x, double y)
	{
	xLeft = x;
	yTop = y;
	}
	
	public void draw (Graphics2D g2)
	{
	Rectangle2D.Double rect = new Rectangle2D.Double (xLeft, yTop + 10, 100, 100);
	g2.draw(rect);	
	}
}
