//Chapter 14 - Exercise 14.11

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankBarChartPanel extends JPanel
{
	private int valuesSize;
	private double[] values;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public BankBarChartPanel()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void setCount(int count)
	{
		values = new double[count];
		valuesSize = 0;
		repaint();
	}
	
	public void addValue(double v)
	{
		if (valuesSize == values.length) 
		{
			return;
		}
		
		values[valuesSize] = v;
		valuesSize++;
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if (valuesSize == 0)
		{
			return;
		}
			
		double max = values[0];
		for (int i = 0; i < valuesSize; i++)
		{
			if (values[i] > max)
			{
				max = values[i];
			}				
		}
		
		for (int i = 0; i < valuesSize; i++)
		{
			double width = getWidth()/values.length;
			double height = values[i]*getHeight()/max;
			
			Rectangle2D.Double bar = new Rectangle2D.Double(i*getWidth()/values.length, getHeight()-height, width, height);
			g2.draw(bar);
		}
	}
}

































































