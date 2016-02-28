//Chapter6 - Exercise P6.3

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class LabelPoint
{
	private double x;
	private double y;
	
	private static final double RADIUS = 2;
	
	public LabelPoint(double aX, double aY)
	{
	x = aX;
	y = aY;
	}

	public void draw(Graphics2D g2)
	{
	Ellipse2D.Double circle = new Ellipse2D.Double(x-RADIUS, y-RADIUS, 2*RADIUS, 2*RADIUS);
	g2.draw(circle);
	
	String label = "(" + x + "," + y + ")";
	g2.drawString(label, (float) x, (float) y);
	}
}