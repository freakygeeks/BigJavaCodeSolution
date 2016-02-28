//Chapter 17 - Exercise 17.7

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

public class House
{
	private double xLeft;
	private double yBottom;
	private Color color;
	private final int WIDTH = 50;
	private final int HEIGHT = 70;
	
	public House(double x, double y, Color aColor)
	{
		xLeft = x;
		yBottom = y;
		color = aColor;
	}
	
	public void draw (Graphics2D g2)
	{
		Rectangle2D.Double front = new Rectangle2D.Double (xLeft, yBottom-WIDTH, WIDTH, WIDTH);
		Rectangle2D.Double door = new Rectangle2D.Double (xLeft+WIDTH/5, yBottom-WIDTH/2, WIDTH/5, WIDTH/2);
		Rectangle2D.Double window = new Rectangle2D.Double (xLeft+WIDTH*3/5, yBottom-WIDTH/2, WIDTH/5, WIDTH/5);
		Line2D.Double roofLeft = new Line2D.Double (xLeft, yBottom-WIDTH, xLeft+WIDTH/2, yBottom-HEIGHT);
		Line2D.Double roofRight = new Line2D.Double (xLeft+WIDTH, yBottom-WIDTH, xLeft+WIDTH/2, yBottom-HEIGHT);
		
		g2.draw(front);
		g2.draw(roofLeft);
		g2.draw(roofRight);
		g2.setColor(color);
		g2.fill(front);
		g2.fill(door);
		g2.fill(window);
		g2.setColor(Color.black);
		g2.draw(front);
		g2.draw(door);
		g2.draw(window);		
	}
}




