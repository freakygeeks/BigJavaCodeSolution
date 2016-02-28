//Chapter8 - Exercise P8.9

import java.awt.Graphics;//use method paintComponent (Graphics g)
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

public class PolygonPerimeterAreaComponent extends JComponent
{
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	PolygonPerimeterArea square = new PolygonPerimeterArea();
	square.add(new Point2D.Double(100, 100));
	square.add(new Point2D.Double(100, 150));
	square.add(new Point2D.Double(150, 150));
	square.add(new Point2D.Double(150, 100));
	
	square.draw(g2);
	
	PolygonPerimeterArea pentagon = new PolygonPerimeterArea();
	double centerX = 200;
	double centerY = 200;
	double radius = 50;
	
	for(int i = 0; i < 5; i++)
		{
		double angle = 2*Math.PI*i/5;
		pentagon.adds(new Point2D.Double(centerX+radius*Math.cos(angle), centerY+radius*Math.sin(angle)));
		}	
	pentagon.draw(g2);
	
	}
}