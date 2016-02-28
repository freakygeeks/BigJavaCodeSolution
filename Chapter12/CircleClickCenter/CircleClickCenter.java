//Chapter 12 - Exercise 12.13

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircleClickCenter
{
	private int x;
	private int y;
	private int n;
	
	public void setLocation (int aX, int aY, int aN)
	{
		x = aX;
		y = aY;
		n = aN;
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double shape = new Ellipse2D.Double (x-(n/2), y-(n/2), n, n);
		g2.draw(shape);
	}
}