//Chapter5 - Exercise P5.11
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D; 
import javax.swing.JComponent;

public class LetterE extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Line2D.Double first = new Line2D.Double (90, 20, 90, 120);
	Line2D.Double second = new Line2D.Double (90, 20, 140, 20);
	Line2D.Double third = new Line2D.Double (90, 70, 140, 70);
	Line2D.Double fourth = new Line2D.Double (90, 120, 140, 120);
	
	g2.draw(first);
	g2.draw(second);
	g2.draw(third);
	g2.draw(fourth);
	}
}