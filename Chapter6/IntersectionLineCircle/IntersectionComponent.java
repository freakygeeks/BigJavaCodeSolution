//Chapter6 - Exercise P6.3

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class IntersectionComponent extends JComponent
{
	private double x;
	private double root;
	
	public IntersectionComponent(double aX)
	{
	x = aX;
	root = 0;
	}
	
	public void paintComponent(Graphics g)
	{
	final double RADIUS = 100;
	
	Graphics2D g2 = (Graphics2D) g;
	
	//draw circle
	Ellipse2D.Double circle = new Ellipse2D.Double (0, 0, 2*RADIUS, 2*RADIUS);
	g2.draw(circle);
	
	//draw line
	Line2D.Double line = new Line2D.Double (x, 0, x, 2*RADIUS);
	g2.draw(line);
	
	//compute intersection
	double a = RADIUS;
	double b = RADIUS;
	this.root = this.root + (Math.sqrt(RADIUS*RADIUS-(x-a)*(x-a)));
	double y1 = b+root;
	double y2 = b-root;
	
	//draw intersection
	LabelPoint p1 = new LabelPoint (x, y1);
	LabelPoint p2 = new LabelPoint (x, y2);
		
	if (this.root >= 0)
		{
		p1.draw(g2);
		p2.draw(g2);
		}
	else 
		g2.drawString("There is no intersection between circle and line", 20, 100);
	}
}