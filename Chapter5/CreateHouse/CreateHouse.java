//Chapter5 - Exercise P5.8 & P5.9
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class CreateHouse extends JComponent
{
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Line2D.Double leftLine = new Line2D.Double (50, 80, 100, 50);
	Line2D.Double rightLine = new Line2D.Double (100, 50, 150, 80);
	Rectangle mainHome = new Rectangle (50, 80, 100, 50);
	Rectangle doorHome = new Rectangle (80, 110, 20, 20);
	Rectangle winHome = new Rectangle (110, 100, 20, 20);
	
	g2.draw(leftLine);
	g2.draw(rightLine);
	g2.draw(mainHome);
	g2.draw(doorHome);
	g2.draw(winHome);
	}
}