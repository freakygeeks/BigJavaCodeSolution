//Chapter 12 - Exercise 12.17

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineTwoMsg
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
		
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
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Line2D.Double shape = new Line2D.Double (x1, y1, x2, y2);
		String label = "rise over run";
		g2.drawString(label, (float) (x1 + ((x2-x1)/2)), (float) (y1 + ((y2-y1)/2)));
		g2.draw(shape);
	}
}