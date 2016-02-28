//Chapter6 -  Exercise 6.6

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class TwoCircleIntersect extends JComponent
{
	private double x1;
	private double y1;
	private double r1;
	private double x2;
	private double y2;
	private double r2;
	
	public TwoCircleIntersect(double rad1, double rad2)
	{	
	r1 = rad1;
	r2 = rad2;
	}
	
	public void paintComponent(Graphics g)
	{
	final double x1 = 200;
	final double y1 = 300;
	final double x2 = 300;
	final double y2 = 200;
	
	Graphics2D g2 = (Graphics2D) g;
	
	double aX = x1-r1;
	double aY = y1-r1;
	double bX = x2-r2;
	double bY = y2-r2;
	
	Ellipse2D.Double circle1 = new Ellipse2D.Double (aX, aY, r1, r1);
	g2.draw(circle1);
	
	Ellipse2D.Double circle2 = new Ellipse2D.Double (bX, bY, r2, r2);
	g2.draw(circle2);
	}
}