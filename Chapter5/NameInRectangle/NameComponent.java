//Chapter5 - Exercise P5.1
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class NameComponent extends JComponent
{
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Name user = new Name(50,50);
	
	user.draw(g2);
	}
}