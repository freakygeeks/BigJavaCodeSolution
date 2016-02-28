//Chapter11 - Exercise P11.11

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class House implements Drawable
{
	private int xLeft;
	private int yBottom;
	
	public House (int x, int y)
	{
	xLeft = x;
	yBottom = y;
	}

	public void draw (Graphics2D g2)
	{
	final int WIDTH = 50;
	final int HEIGHT = 75;
	
	Rectangle2D.Double front = new Rectangle2D.Double (xLeft, yBottom - WIDTH, WIDTH, WIDTH);
	Rectangle2D.Double door = new Rectangle2D.Double (xLeft + WIDTH/5, yBottom - WIDTH/2, WIDTH/5, WIDTH/2);
	Rectangle2D.Double window = new Rectangle2D.Double (xLeft + WIDTH*3/5, yBottom - WIDTH/2, WIDTH/5, WIDTH/5);
	Rectangle2D.Double roofLeft = new Rectangle2D.Double (xLeft, yBottom - WIDTH, xLeft + WIDTH/2, yBottom - HEIGHT);
	Rectangle2D.Double roofRight = new Rectangle2D.Double (xLeft + WIDTH, yBottom - WIDTH, xLeft + WIDTH/2, yBottom - HEIGHT);
	
	g2.draw(front);
	g2.draw(door);
	g2.draw(window);
	g2.draw(roofLeft);
	g2.draw(roofRight);
	}
}