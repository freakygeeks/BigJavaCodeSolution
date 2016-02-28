//Chapter 14 - Exercise 14.9

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.util.Random;

public class RectangleSliderPanel extends JPanel
{
	private int rectCount;
	private Rectangle2D.Double shape;
	private static final double S_WIDTH = 100;
	private static final double S_HEIGHT = 100;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	public RectangleSliderPanel()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Random gen = new Random();
		
		for(int i = 0; i < rectCount; i++)
			{
				double x = getWidth()*gen.nextDouble();
				double y = getHeight()*gen.nextDouble();
				shape = new Rectangle2D.Double(x, y, S_WIDTH, S_HEIGHT);
				g2.draw(shape);
			}
	}
	
	public void setCount(int count)
	{
		rectCount = count;
		repaint();
	}
}
























