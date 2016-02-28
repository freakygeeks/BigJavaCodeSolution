//Chapter 12 - Example 12.4

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
	private Rectangle box;
	private static final int X = 100;
	private static final int Y = 100;
	private static final int WIDTH = 20;
	private static final int HEIGHT = 30;
	
	public RectangleComponent()
	{
		box = new Rectangle(X, Y, WIDTH, HEIGHT);
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.draw(box);
	}
	
	public void moveTo(int aX, int aY)
	{
		box.setLocation(aX, aY);
		repaint();
	}
}