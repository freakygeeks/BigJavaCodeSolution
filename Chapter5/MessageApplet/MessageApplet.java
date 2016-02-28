//Chapter5 - Advanced Topic 5.1
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JApplet;
import java.awt.Color;

public class MessageApplet extends JApplet
{
	public void paint(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double circle = new Ellipse2D.Double (5,10,2,2);
	g2.setColor(Color.RED);
	g2.fill(circle);
	g2.draw(circle);
	
	Line2D.Double segment = new Line2D.Double(5,10,60,10);
	g2.draw(segment);
	g2.setColor(Color.GREEN);
	g2.drawString("Message",5,10);
	}
}