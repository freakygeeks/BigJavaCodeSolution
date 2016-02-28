//Chapter 17 - Exercise 17.7

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Street extends JPanel
{
	private ArrayList house;
	private ArrayList car;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	
	public Street()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		car = new ArrayList();
		house = new ArrayList();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//draw street
		double xwidth = getWidth();
		Line2D.Double line1 = new Line2D.Double(0, 100, xwidth, 100);
		Line2D.Double line2 = new Line2D.Double(0, 200, xwidth, 200);
		
		int start1 = 0;
		int start2 = 0;
		
		g2.draw(line1);
		
		while (start2 <= xwidth)
		{
			Line2D.Double dashline = new Line2D.Double(start1, 150, start2, 150);
			start1 = start1 + 100;
			start2 = start2 + 100;
			g2.draw(dashline);
		}
		
		g2.draw(line2);
		
		for (int i = 0; i < house.size(); i++)
		{
			House h = (House)house.get(i);
			h.draw(g2);
		}
		
		for (int i = 0; i < car.size(); i++)
		{
			Car c = (Car)car.get(i);
			c.draw(g2);
		}		
	}
	
	public void addCar (Car c)
	{
		car.add(c);
		repaint();
	}
	
	public void addHouse (House h)
	{
		house.add(h);
		repaint();
	}
}

















