//Chapter5 - Exercise P5.14
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;

public class OlympicRing extends JComponent
{
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double blue = new Ellipse2D.Double (50, 50, 100, 100);
	Ellipse2D.Double black = new Ellipse2D.Double (150, 50, 100, 100);
	Ellipse2D.Double red = new Ellipse2D.Double (250, 50, 100, 100);
	Ellipse2D.Double yellow = new Ellipse2D.Double (100, 100, 100, 100);
	Ellipse2D.Double green = new Ellipse2D.Double (200, 100, 100, 100);
	
	g2.setColor(Color.BLUE);
	g2.draw(blue);
	g2.setColor(Color.BLACK);
	g2.draw(black);
	g2.setColor(Color.RED);
	g2.draw(red);
	g2.setColor(Color.YELLOW);
	g2.draw(yellow);
	g2.setColor(Color.GREEN);
	g2.draw(green);
	}
}