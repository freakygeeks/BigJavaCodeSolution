//Chapter 12 - Exercise 12.12

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircleCenterRadius
{
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	private int x;
	private int y;
	private int n;

	public CircleCenterRadius()
	{
		Ellipse2D.Double shape = new Ellipse2D.Double (0, 0, WIDTH, HEIGHT);
	}
	
	public void setValue (int aX, int aY, int aN)
	{
		x = aX;
		y = aY;
		n = aN;
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D.Double shape = new Ellipse2D.Double (x-n, y-n, 2*n, 2*n);
		g2.draw(shape);
	}
}