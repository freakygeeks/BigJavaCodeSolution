//Chapter 23 - Example 23.6

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

public class SelectionSorter
{
	private static final int DELAY = 100;
	private int[] a;
	private Lock sortStateLock;
	private JComponent component;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	
	public SelectionSorter(int[] anArray, JComponent aComponent)
	{
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}
	
	public void sort() throws InterruptedException
	{
		for (int i = 0; i < a.length-1; i++)
		{
			int minPos = minimumPosition(i);
			sortStateLock.lock();
			
			try
			{
				swap(minPos, i);
				alreadySorted = i;
			}
			
			finally
			{
				sortStateLock.unlock();
			}
			
			pause(2);
		}
	}
	
	//find the smallest element in a tail range of the array
	private int minimumPosition(int from) throws InterruptedException
	{
		int minPos = from;
		
		for (int i =  from + 1; i < a.length; i++)
		{
			sortStateLock.lock();
			try
			{
				if (a[i] < a[minPos])
				{
					minPos = i;
				}
				
				markedPosition = i;
			}
			
			finally
			{
				sortStateLock.unlock();
			}
			
			pause(2);
		}
		
		return minPos;
	}
	
	//swap two entries of the array
	private void swap (int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//draw the current state of sorting algorithm
	public void draw (Graphics2D g2)
	{
		sortStateLock.lock();
		
		try
		{
			int deltaX = component.getWidth()/a.length;
			
			for (int i = 0; i < a.length; i++)
			{
				if (i == markedPosition)
				{
					g2.setColor(Color.RED);
				}
				else if (i <= alreadySorted)
				{
					g2.setColor(Color.BLUE);
				}
				else
				{
					g2.setColor(Color.BLACK);
				}
				
				g2.draw(new Line2D.Double(i * deltaX, 0, i * deltaX, a[i]));
			}
		}
		
		finally
		{
			sortStateLock.unlock();
		}
	}
	
	//pauses animation
	public void pause (int steps) throws InterruptedException
	{
		component.repaint();
		Thread.sleep(steps * DELAY);
	}
}



























