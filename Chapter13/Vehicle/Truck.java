//Chapter 13 - Exercise 13.7

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Truck extends Vehicle
{
	private final int WIDTH = 100;
	private final int HEIGHT = WIDTH/2;
	private int xLeft;
	private int yTop;
	
	public Truck()
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
		int yBottom = yTop+HEIGHT*4/5;
		int tireDiameter = WIDTH/10;
	
		Rectangle body = new Rectangle (xLeft, yTop+HEIGHT/5, WIDTH/5, HEIGHT*3/5);
		Rectangle cargo = new Rectangle (xLeft+WIDTH/5, yTop, WIDTH*4/5, HEIGHT*4/5);
		Ellipse2D.Double frontTire = new Ellipse2D.Double (xLeft, yBottom, tireDiameter, tireDiameter);
		Ellipse2D.Double midTireOne = new Ellipse2D.Double (xLeft+WIDTH*1/5, yBottom, tireDiameter, tireDiameter);
		Ellipse2D.Double midTireTwo = new Ellipse2D.Double (xLeft+WIDTH*3/10, yBottom, tireDiameter, tireDiameter);
		Ellipse2D.Double rearTireOne = new Ellipse2D.Double (xLeft+WIDTH*4/5, yBottom, tireDiameter, tireDiameter);
		Ellipse2D.Double rearTireTwo = new Ellipse2D.Double (xLeft+WIDTH*9/10, yBottom, tireDiameter, tireDiameter);
		
		g2.draw(body);
		g2.draw(cargo);
		g2.draw(frontTire);
		g2.draw(midTireOne);
		g2.draw(midTireTwo);
		g2.draw(rearTireOne);
		g2.draw(rearTireTwo);
	}
}