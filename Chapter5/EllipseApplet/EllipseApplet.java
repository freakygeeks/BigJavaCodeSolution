//Chapter5 - Advanced Topic 5.1
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JApplet;

public class EllipseApplet extends JApplet
{
	public void paint(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double ellipse = new Ellipse2D.Double(5,10,20,30);
	g2.draw(ellipse);
	}
}
	