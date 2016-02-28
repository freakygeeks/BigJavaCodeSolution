//Chapter 12 - Example 12.4

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class RectangleComponentViewer
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	
	public static void main (String[] args)
	{
		final RectangleComponent comp = new RectangleComponent();
		
		class MousePressListener implements MouseListener
		{
			public void mousePressed (MouseEvent event)
			{
				int x = event.getX();
				int y = event.getY();
				
				comp.moveTo(x, y);
			}
		
			public void mouseReleased (MouseEvent event)
			{
			}
			
			public void mouseClicked(MouseEvent event)
			{
			}
			
			public void mouseEntered (MouseEvent event)
			{
			}
			
			public void mouseExited (MouseEvent event)
			{
			}
		}
		
		MouseListener listener = new MousePressListener();
		comp.addMouseListener(listener);
		
		JFrame frame = new JFrame();
		frame.add(comp);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}