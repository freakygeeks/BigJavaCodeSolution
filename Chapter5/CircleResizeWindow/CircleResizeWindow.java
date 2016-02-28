//Chapter5 - Exercise P5.7
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;

public class CircleResizeWindow extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double circleSize = new Ellipse2D.Double (0,0, getWidth(), getHeight());
	
	g2.setColor(Color.RED);
	g2.fill(circleSize);
	g2.draw(circleSize);
	}
}