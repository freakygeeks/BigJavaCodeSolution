//Chapter 12 - Exercise 12.14

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class CircleTwoPress
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
		
	public void setCenter (int aX, int aY)
	{
		x1 = aX;
		y1 = aY;
	}
	
	public void setPeripheral (int bX, int bY)
	{
		x2 = bX;
		y2 = bY;
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double shape = new Ellipse2D.Double (x2, y2, (y1-y2)*2, (x1-x2)*2);
		g2.draw(shape);
	}
}