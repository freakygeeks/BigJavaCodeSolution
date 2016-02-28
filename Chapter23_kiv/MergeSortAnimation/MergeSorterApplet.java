//Chapter 23 - Exercise 23.11

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class MergeSorterApplet extends Applet
{
	private MergeSorter sorter;
	private Thread animation;
	
	public MergeSorterApplet()
	{
		class MousePressListener extends MouseAdapter
		{
			public void mousePressed(MouseEvent event)
			{
				if (animation != null && animation.isAlive())
				{
					animation.interrupt();
				}
				startAnimation();
			}
		}
		
		MouseListener listener = new MousePressListener();
		addMouseListener(listener);
		setBackground(Color.lightGray);
		
		sorter = null;
		animation = null;
	}
	
	public void paint(Graphics g)
	{
		if (sorter == null)
		{
			return;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		sorter.draw(g2);
	}
	
	public void startAnimation()
	{
		class AnimationThread extends Thread
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
		
		int[] values = ArrayUtil.randomIntArray(30, 300);
		sorter = new MergeSorter(values, this);
		animation = new AnimationThread();
		animation.start();
	}
}




















