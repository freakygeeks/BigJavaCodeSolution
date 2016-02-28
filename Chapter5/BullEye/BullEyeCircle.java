//Chapter5 - Exercise P5.6
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;

public class BullEyeCircle extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double circle1 = new Ellipse2D.Double (60, 140, 100, 100);
	Ellipse2D.Double circle2 = new Ellipse2D.Double (70, 150, 80, 80);
	Ellipse2D.Double circle3 = new Ellipse2D.Double (80, 160, 60, 60);
	Ellipse2D.Double circle4 = new Ellipse2D.Double (90, 170, 40, 40);
	Ellipse2D.Double circle5 = new Ellipse2D.Double (100, 180, 20, 20);
	
	g2.setColor(Color.BLUE);
	g2.fill(circle1);
	g2.draw(circle1);
	
	g2.setColor(Color.YELLOW);
	g2.fill(circle2);
	g2.draw(circle2);
	
	g2.setColor(Color.GREEN);
	g2.fill(circle3);
	g2.draw(circle3);
	
	g2.setColor(Color.RED);
	g2.fill(circle4);
	g2.draw(circle4);
	
	g2.setColor(Color.WHITE);
	g2.fill(circle5);
	g2.draw(circle5);
	}
}