//Chapter5 - Exercise P5.11
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class LetterL1 extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Line2D.Double first = new Line2D.Double (170, 20, 170, 120);
	Line2D.Double second = new Line2D.Double (170, 120, 220, 120);
	
	g2.draw(first);
	g2.draw(second);
	}
}