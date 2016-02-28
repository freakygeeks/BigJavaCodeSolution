//Chapter5 - Example 5.2
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;

public class RectangleComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;//recover Graphics2D
	
	Rectangle box = new Rectangle(5,10,20,30);//construct a rectangle (x,y,width,height)
	g2.draw(box);//draw a rectangle
	
	box.translate(15,25);//move rectangle 15 units to right and 25 units down
	g2.draw(box);//draw moved rectangle
	
	box.translate(15,25);
	g2.setColor(Color.RED);
	g2.draw(box);
	}
}