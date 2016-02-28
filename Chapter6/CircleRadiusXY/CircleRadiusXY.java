//Chapter6 - Exercise P6.5

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import java.lang.Math;

public class CircleRadiusXY extends JComponent
{
	private double x;
	private double y;
	private double xMin;
	private double xMax;
	private double yMin;
	private double yMax;
	
	public CircleRadiusXY(double aX, double aY)
	{
	x = aX;
	y = aY;
	xMin = 0;
	xMax = 0;
	yMin = 0;
	yMax = 0;
	}
	
	public void paintComponent (Graphics g)
	{
	final double RADIUS = 100;
	final double pointX = 110;
	final double pointY = 120;
	
	Graphics2D g2 = (Graphics2D) g;
	
	//draw circle
	Ellipse2D.Double circle = new Ellipse2D.Double (10, 20, RADIUS, RADIUS);
	
	double xMax = pointX + RADIUS;
	double yMax = pointY + RADIUS;
	double xMin = pointX - RADIUS;
	double yMin = pointY - RADIUS;
		
	if (xMin <= this.x && this.x <= xMax)
		{
		if (yMin <= this.y && this.y <= yMax)
			{
			g2.drawString("Congratulations!", 20, 50);
			g2.draw(circle);
			}
		else
			g2.drawString("You missed a little!", 20, 50);
		}
	else
		g2.drawString("You missed!",20, 50);
	}
	
	/*public boolean isInside()
   {
   boolean inside = false;
	if (xMin <= this.x && this.x <= xMax)
		{
		if (yMin <= this.y && this.y <= yMax)
			{
			inside = true;
			}
		else
			inside = false;
		}
	else
		inside = false;
		
		return inside;
   }*/
}