//Chapter 12 - Project 12.2

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegressionLineViewer extends JComponent implements MouseListener
{

	private RegressionLine shape;
	private int n;
	private double sum_x;
	private double sum_y;
	private double sum_xx;
	private double sum_xy;

	public RegressionLineViewer()
	{
		shape = new RegressionLine();
		sum_x = 0;
		sum_y = 0;
		sum_xx = 0;
		sum_xy = 0;
		n = 0;
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
	
		JPanel inputPanel =new JPanel();
		
		buttonPanel.add(inputPanel);
		
		addMouseListener(this);
		
		return buttonPanel;
	}
	
	public void mousePressed (MouseEvent event)
	{
	
	    int mouseX = event.getX();
        int mouseY = event.getY();
        sum_x += mouseX;
        sum_y += mouseY;
        sum_xx += mouseX * mouseX;
        sum_xy += mouseX * mouseY;
        n++;
		shape.setVariable(n, getWidth(), sum_x, sum_y, sum_xx, sum_xy);
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
		frame.setTitle("Regression Lines");
		
		RegressionLineViewer component = new RegressionLineViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);	
	}
}