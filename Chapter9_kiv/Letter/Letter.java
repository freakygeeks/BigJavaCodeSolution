//Chapter 9 - Exercise 9.12

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Letter
{
	private static final int WIDTH = 30;
	private static final int HEIGHT = 50;
	
	public static void drawH (Graphics2D g2, Point2D.Double p)
	{
		double x = p.getX();
		double y = p.getY();
		Line2D.Double vert1 = new Line2D.Double(x, y, x, y + HEIGHT);
		Line2D.Double vert2 = new Line2D.Double(x + WIDTH, y, x + WIDTH, y + HEIGHT);
		Line2D.Double horiz = new Line2D.Double(x, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);
		
		g2.draw(vert1);
		g2.draw(vert2);
		g2.draw(horiz);
	}
	
	public static void drawL(Graphics2D g2, Point2D.Double p)
	{
		double x = p.getX();
		double y = p.getY();
		Line2D.Double vert = new Line2D.Double(x, y, x, y + HEIGHT);
		Line2D.Double horiz = new Line2D.Double(x, y + HEIGHT, x + WIDTH, y + HEIGHT);
		
		g2.draw(vert);
		g2.draw(horiz);
	}
	
	public static void drawE (Graphics2D g2, Point2D.Double p)
	{
		drawL(g2, p);
		double x = p.getX();
		double y = p.getY();
		Line2D.Double horiz1 = new Line2D.Double(x, y, x + WIDTH, y);
		Line2D.Double horiz2 = new Line2D.Double(x, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);
		
		g2.draw(horiz1);
		g2.draw(horiz2);
	}
	
	public static void drawO(Graphics2D g2, Point2D.Double p)
	{
		double x = p.getX();
		double y = p.getY();
		Ellipse2D.Double e = new Ellipse2D.Double(x, y, WIDTH, HEIGHT);

		g2.draw(e);
	}
}