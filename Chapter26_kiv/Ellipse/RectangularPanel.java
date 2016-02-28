//Chapter 26 - Exercise 26.9

import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class RectangularPanel extends JPanel
{
	private Shape s;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public RectangularPanel(Shape aShape)
	{
		s = aShape;
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(s);
	}
}