//Chapter 23 - Example 23.6

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class SelectionSortComponent extends JComponent
{
	private SelectionSorter sorter;
	
	public SelectionSortComponent()
	{
		int[] values = ArrayUtil.randomIntArray(30, 300);
		sorter = new SelectionSorter(values, this);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		sorter.draw(g2);
	}
	
	public void startAnimation()
	{
		class AnimationRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					sorter.sort();
				}
				
				catch (InterruptedException exception)
				{
				}
			}
		}
		
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}

















