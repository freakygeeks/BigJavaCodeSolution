//Chapter 12 - Exercise 12.16

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class CircleThreePoint
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
		
	public void setFirst (int aX, int aY)
	{
		x1 = aX;
		y1 = aY;
	}
	
	public void setSecond (int bX, int bY)
	{
		x2 = bX;
		y2 = bY;
	}
	
	public void setThird (int cX, int cY)
	{
		x3 = cX;
		y3 = cY;
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double shape1 = new Ellipse2D.Double (x1, y1, 10, 10);
		Ellipse2D.Double shape2 = new Ellipse2D.Double (x2, y2, 10, 10);
		Ellipse2D.Double shape3 = new Ellipse2D.Double (x3, y3, 10, 10);
		Line2D.Double triangle1 = new Line2D.Double (x1, y1, x2, y2);
		Line2D.Double triangle2 = new Line2D.Double (x2, y2, x3, y3);
		Line2D.Double triangle3 = new Line2D.Double (x3, y3, x1, y1);
		g2.draw(shape1);
		g2.draw(shape2);
		g2.draw(shape3);
		g2.draw(triangle1);
		g2.draw(triangle2);
		g2.draw(triangle3);
	}
}