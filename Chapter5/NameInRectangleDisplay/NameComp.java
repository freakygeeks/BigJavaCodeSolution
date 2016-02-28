//Chapter5 - Exercise P5.2
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JComponent;

public class NameComp extends JComponent
{
	private String name;
	
	public NameComp (String n)
	{
	name = n;
	}
	
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Rectangle rect = new Rectangle (50, 150, 200, 100);
	g2.setColor(Color.BLUE);
	g2.draw(rect);
	g2.setColor(Color.RED);
	g2.drawString(name,125,200);
	}
}
	