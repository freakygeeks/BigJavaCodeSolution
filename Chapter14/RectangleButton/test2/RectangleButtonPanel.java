

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.util.Random;

public class RectangleButtonPanel extends JPanel
{
	private Random gen;
	private Rectangle shape;
	private int n;
	private static final int X = 50;
	private static final int Y = 50;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	private static final int RANDOM = 600;
	
	public RectangleButtonPanel()
	{
		shape = new Rectangle(X, Y, WIDTH, HEIGHT);
	}
	
	public void setNumber(int num)
	{
		n = num;
	}
	
	public void randomLocation()
	{
		int x = 100;
		int y = 100;
		
		for (int i = 0; i < n; i++)
			{
				x = gen.nextInt(RANDOM);
				y = gen.nextInt(RANDOM);
			}		
			
		shape.setLocation(x,y);
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(shape);
	}
	
	/*public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Random gen = new Random();
		
		int x = 100;
		int y = 100;
		
		for (int i = 0; i < n; i++)
			{
			x = gen.nextInt(RANDOM);
			y = gen.nextInt(RANDOM);
			
			shape.setLocation(x, y);
			g2.draw(shape);
			}
	}*/
}
















