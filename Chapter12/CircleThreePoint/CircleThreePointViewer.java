//Chapter 12 - Exercise 12.16

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CircleThreePointViewer extends JComponent implements MouseListener
{
	private JTextField nField;
	private CircleThreePoint shape;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int click;
	
	public CircleThreePointViewer()
	{
		shape = new CircleThreePoint();
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		shape.paint(g);
	}
	
	private Component createControlPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
	
		addMouseListener(this);
		
		return buttonPanel;
	}
	
	public void mousePressed (MouseEvent event)
	{	
		click++;
		
		int aX = event.getX();
		int aY = event.getY();
		int bX = event.getX();
		int bY = event.getY();
		int cX = event.getX();
		int cY = event.getY();

		if (click == 1)
			{
				int x1 = aX;
				int y1 = aY;
				//System.out.println("first click detected " + x1 + " , " + y1);
				shape.setFirst(x1, y1);	
			}
			
		if (click == 2)
			{
				int x2 = bX;
				int y2 = bY;
				//System.out.println("first click detected " + x2 + " , " + y2);
				shape.setSecond(x2, y2);	
			}
			
		if (click == 3)
			{
				int x3 = cX;
				int y3 = cY;
				//System.out.println("third click detected " + x3 + " , " + y3);
				shape.setThird(x3, y3);	
				repaint();	
				click = 0;
			}
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
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("Circle Three Point");
		
		CircleThreePointViewer component = new CircleThreePointViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);	
	}
}