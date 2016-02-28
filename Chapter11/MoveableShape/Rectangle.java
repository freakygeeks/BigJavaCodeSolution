//Chapter11 - Project P11.1

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

public class Rectangle extends JComponent implements MoveableShape 
{
	private double xLeft;
	private double yTop;
		
	public Rectangle(double x, double y)
	{
	xLeft = x;
	yTop = y;
	}
	
	public void translate (double aX, double aY)
	{
		xLeft  = xLeft + aX;
		yTop = yTop + aY;
	}
	
	public void draw (Graphics2D g2)
	{
	Rectangle2D.Double rect = new Rectangle2D.Double (xLeft, yTop + 10, 100, 100);
	g2.draw(rect);	
	}
}
