//Chapter 16 - Project 16.1
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch19/c19_exp_19_11

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Car implements Serializable //a car shape that can be positioned anywhere on the screen
{
	private double xLeft;
	private double yTop;
	
	public Car(double x, double y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void draw (Graphics2D g2)
	{
		Rectangle2D.Double body = new Rectangle2D.Double (xLeft, yTop + 10, 60, 10);
		Ellipse2D.Double frontTire = new Ellipse2D.Double (xLeft + 10 , yTop + 20, 10, 10);
		Ellipse2D.Double rearTire = new Ellipse2D.Double (xLeft + 40, yTop + 20, 10, 10);
		
		Point2D.Double r1 = new Point2D.Double (xLeft + 10, yTop + 10);
		Point2D.Double r2 = new Point2D.Double (xLeft + 20, yTop);
		Point2D.Double r3 = new Point2D.Double (xLeft + 40, yTop);
		Point2D.Double r4 = new Point2D.Double (xLeft + 50, yTop + 10);
		
		Line2D.Double frontWind = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double (r2, r3);
		Line2D.Double rearWind = new Line2D.Double (r3, r4);
		
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWind);
		g2.draw(roofTop);
		g2.draw(rearWind);
	}
}



























































