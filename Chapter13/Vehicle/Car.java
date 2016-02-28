//Chapter 13 - Exercise 13.7

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Car extends Vehicle
{
	private final int WIDTH = 60;
	private final int HEIGHT = WIDTH/2;
	private int xLeft;
	private int yTop;
	
	public Car()
	{
		xLeft = 0;
		yTop = 0;
	}
	
	public void setLocation (int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void draw (Graphics2D g2)
	{
		Rectangle body = new Rectangle (xLeft, yTop+HEIGHT/3, WIDTH, HEIGHT/3);
		Ellipse2D.Double frontTire = new Ellipse2D.Double (xLeft+WIDTH/6, yTop+HEIGHT*2/3, WIDTH/6, WIDTH/6);
		Ellipse2D.Double rearTire = new Ellipse2D.Double (xLeft+WIDTH*4/6, yTop+HEIGHT*2/3, WIDTH/6, WIDTH/6);
		Point2D.Double r1 = new Point2D.Double (xLeft+WIDTH/6, yTop+HEIGHT/3);
		Point2D.Double r2 = new Point2D.Double (xLeft+WIDTH*2/6, yTop);
		Point2D.Double r3 = new Point2D.Double (xLeft+WIDTH*4/6, yTop);
		Point2D.Double r4 = new Point2D.Double (xLeft+WIDTH*5/6, yTop+HEIGHT/3);
		Line2D.Double frontWind = new Line2D.Double (r1, r2);
		Line2D.Double rearWind = new Line2D.Double (r3, r4);
		Line2D.Double roofTop = new Line2D.Double (r2, r3);
		
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWind);
		g2.draw(rearWind);
		g2.draw(roofTop);
	}
}