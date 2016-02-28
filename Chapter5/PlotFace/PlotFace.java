//Chapter5 - Exercise P5.10
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class PlotFace extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double bigSmile = new Ellipse2D.Double (50, 50, 100, 100);
	Ellipse2D.Double oneEye = new Ellipse2D.Double (80, 80, 10, 10);
	Ellipse2D.Double twoEye = new Ellipse2D.Double (120, 80, 10, 10);
	Line2D.Double mouth = new Line2D.Double (80, 120, 120, 120);
	
	g2.draw(bigSmile);
	g2.draw(oneEye);
	g2.draw(twoEye);
	g2.draw(mouth);
	}
}