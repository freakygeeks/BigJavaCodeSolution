//Chapter5 - Exercise P5.11
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class LetterO extends JComponent
{
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double first = new Ellipse2D.Double(310, 20, 50, 100);
	
	g2.draw(first);
	}
}