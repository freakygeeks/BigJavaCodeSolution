//Chapter 26 - Exercise 26.11

import java.util.ArrayList;
import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.AWTEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class DrawFrame extends JFrame
{
	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();
	private DrawPanel drawPanel;
	
	public DrawFrame(ArrayList aList)
	{
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		
		try
		{
			contentPane = (JPanel)this.getContentPane();
			contentPane.setLayout(borderLayout1);
			this.setSize(new Dimension(400, 300));
			this.setTitle("Drawing");
			drawPanel = new DrawPanel(aList);
			contentPane.add(drawPanel, BorderLayout.CENTER);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void processWindowEvent (WindowEvent e)
	{
		super.processWindowEvent(e);
		
		if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			System.exit(0);
		}
	}
}



















