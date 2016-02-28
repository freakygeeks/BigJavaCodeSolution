//Chapter5 - Example 5.7

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class IntersectionComponent extends JComponent
{
	private double x;
	
	public IntersectionComponent(double aX)
	{
	x = aX;
	}
	
	public void paintComponent(Graphics g)
	{
	final double RADIUS = 100;
		
	Graphics2D g2 = (Graphics2D) g;
	
	//draw the circle
	Ellipse2D.Double circle = new Ellipse2D.Double (0, 0, 2*RADIUS, 2*RADIUS);
	g2.draw(circle);
	//draw vertical line
	Line2D.Double line = new Line2D.Double (x, 0, x, 2*RADIUS);
	g2.draw(line);
	//compute intersection points
	double a = RADIUS;
	double b = RADIUS;
	double root = Math.sqrt(RADIUS*RADIUS-(x-a)*(x-a));
	double y1 = b + root;
	double y2 = b - root;
	//draw the intersection point
	LabelPoint p1 = new LabelPoint(x, y1);
	LabelPoint p2 = new LabelPoint(x, y2);
	
	p1.draw(g2);
	p2.draw(g2);
	}
}
	