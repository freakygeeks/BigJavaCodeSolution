//Chapter 26 - Exercise 26.7

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;

public class RectanglePanel extends JPanel
{
	private Rectangle box;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public RectanglePanel(Rectangle aBox)
	{
		box = aBox;
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(box);
	}
}