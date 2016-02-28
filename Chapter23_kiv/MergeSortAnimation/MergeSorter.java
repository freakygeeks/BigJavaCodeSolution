//Chapter 23 - Exercise 23.11
	
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
	
public class MergeSorter
{
	private int[] a;
	private int markedPosition = -1;
	private int startPosition = -1;
	private int endPosition = -1;
	private Applet applet;
	private static final int DELAY = 100;
	
	public MergeSorter (int[] anArray, Applet anApplet)
	{
		a = anArray;
		applet = anApplet;
	}
	
	public void sort() throws InterruptedException
	{
		mergeSort(0, a.length - 1);
	}
	
	public void mergeSort (int from, int to) throws InterruptedException
	{
		if (from == to)
		{
			return;
		}
		
		int mid = (from + to) /2;
		mergeSort(from, mid);
		mergeSort(mid + 1, to);
		merge(from, mid, to);
	}
	
	public void merge (int from, int mid, int to) throws InterruptedException
	{
		startPosition = from;
		endPosition = to;
		
		int n = to - from + 1;
		int[] b = new int[n];
		int i1 = from;
		int i2 = mid + 1;
		int j = 0;
		
		while (i1 <= mid && i2 <= to)
		{
			if (a[i1] < a[i2])
			{
				b[j] = a[i1];
				markedPosition = i1;
				i1++;
			}
			
			else
			{
				b[j] = a[i2];
				markedPosition = i2;
				i2++;
			}
			
			pause(4);
			j++;
		}
		
		while (i1 <= mid)
		{
			b[j] = a[i1];
			markedPosition = i1;
			pause(2);
			i1++;
			j++;
		}
		
		while (i2 <= to)
		{
			b[j] = a[i2];
			markedPosition = i2;
			pause(2);
			i2++;
			j++;
		}
		
		for (j = 0; j < n; j++)
		{
			a[from+j] = b[j];
			markedPosition = from+j;
			pause(2);
		}
	}
	
	public void draw (Graphics2D g2)
	{
		if (a == null)
		{
			return;
		}
		
		int deltaX = applet.getWidth() / a.length;
		
		for (int i = 0; i < a.length; i++)
		{
			if (i == markedPosition)
			{
				g2.setColor(Color.red);
			}
			else if (startPosition <= i && i <= endPosition)
			{
				g2.setColor(Color.blue);
			}
			else
			{
				g2.setColor(Color.black);
			}
			g2.draw(new Line2D.Double(i*deltaX, 0, i*deltaX, a[i]));
		}
	}
	
	public void pause (int steps) throws InterruptedException
	{
		if (Thread.currentThread().isInterrupted()) 
		{
			throw new InterruptedException();
		}
		applet.repaint();
		Thread.sleep(steps*DELAY);
	}
}

	













