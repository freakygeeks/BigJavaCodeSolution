//Chapter5 - Advanced Topic 5.1
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JApplet;
import java.awt.Color;

public class RectangleApplet extends JApplet
{
	public void paint(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;//call the graphic
	
	Rectangle box = new Rectangle (5,10,20,30); //(x,y,width,height)
	g2.draw(box);
	
	box.translate(15,25);//move 15 unit right and 25 unit down
	g2.setColor(Color.RED);
	g2.draw(box);
	}
}