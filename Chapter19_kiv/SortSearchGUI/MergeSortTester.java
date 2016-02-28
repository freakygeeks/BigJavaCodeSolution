//Chapter 19 - Project 19.2

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class MergeSortTester extends JApplet
{
	private int[] a;
	private boolean first;
	private static final int YMAX = 100;
	
	public void init()
	{
		a = ArrayUtil.randomIntArray(20, YMAX);
		first = true;
	}
	
	public void paint (Graphics g)
	{
		if (first)
		{
			first = false;
			MergeSort sorter = new MergeSort(a, this);
			sorter.sort(0, a.length-1);
		}
		
		Graphics2D g2 = (Graphics2D) g;
		double width = getWidth();
		double height = getHeight();
		
		g2.setColor(Color.white);
		g2.fill (new Rectangle2D.Double(0, 0, width, height));
		g2.setColor(Color.black);
		
		for (int i = 0; i < a.length; i++)
		{
			double x = i*width/a.length;
			double y = a[i]*height/YMAX;
			Line2D.Double line = new Line2D.Double (x, 0, x, y);
			g2.draw(line);
		}
	}
}