//Chapter 14 - Exercise 14.12

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import java.awt.Dimension;
import javax.swing.JPanel;

public class BarChartPanel extends JPanel
{
	private Vector bars;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public BarChartPanel()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		bars = new Vector();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if (bars.size() == 0)
		{
			return;
		}
		
		BarChart b = (BarChart)bars.get(0);
		double max = b.getLength();
		
		for (int i = 1; i < bars.size(); i++)
		{
			b = (BarChart)bars.get(i);
			if (b.getLength() > max)
			{
				max = b.getLength();
			}
		}
		
		for (int i = 0; i<bars.size(); i++)
		{
			b = (BarChart)bars.get(i);
			double height = getHeight()/bars.size();
			double width = b.getLength()*getWidth()/max;
			
			int x = 0;
			int y = i*getHeight()/bars.size();
			
			Rectangle2D.Double bar = new Rectangle2D.Double(0, y, width, height);
			
			g2.setColor(b.getColor());
			g2.fill(bar);
			g2.setColor(Color.black);
			g2.draw(bar);
			g2.drawString(b.getName(), x, y + (int)(height/2));
		}
	}
	
	public void addBar(BarChart b)
	{
		bars.add(b);
		repaint();
	}
}
























