//Chapter 12 - Exercise 12.13

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

public class CircleClickCenterViewer extends JComponent implements MouseListener
{
	private JTextField nField;
	private CircleClickCenter shape;
	
	public CircleClickCenterViewer()
	{
		shape = new CircleClickCenter();
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
	
		JPanel radiusPanel = new JPanel();
		
		radiusPanel.add(new JLabel ("Enter value radius"));
		nField = new JTextField(5);
		radiusPanel.add(nField);		
		
		buttonPanel.add(radiusPanel);
		addMouseListener(this);
		
		return buttonPanel;
	}
	
	public void mousePressed (MouseEvent event)
	{
		int x = event.getX();
		int y = event.getY();
		
		int n;
		String nText = nField.getText();
		if(nText.equals(""))
			{
				n = 0;
			}
		else
			{
				n = Integer.parseInt(nText);
			}
		
		shape.setLocation(x,y,n);	
		repaint();	
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
		frame.setTitle("Circle Click Center");
		
		CircleClickCenterViewer component = new CircleClickCenterViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);	
	}
}