//Chapter5 - Exercise P5.4
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class CircleRadius extends JComponent
{
	private double rad;
	
	public CircleRadius(double radius)
	{
	rad = radius;
	}
	
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double circle = new Ellipse2D.Double (50, 50, 2*rad, 2*rad);
	g2.draw(circle);
	}
}