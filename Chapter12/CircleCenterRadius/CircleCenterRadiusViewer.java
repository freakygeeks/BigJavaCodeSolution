//Chapter 12 - Exercise 12.12

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CircleCenterRadiusViewer extends JComponent implements ActionListener
{
	private JTextField xField;
	private JTextField yField;
	private JTextField nField;
	private CircleCenterRadius shape;
	
	public CircleCenterRadiusViewer()
	{
		shape = new CircleCenterRadius();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		shape.paint(g);
	}
	
	private Component createControlPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout (new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
		
		JPanel drawPanel = new JPanel();
		
		drawPanel.add (new JLabel ("Enter value X"));
		xField = new JTextField(5);
		drawPanel.add(xField);
		
		drawPanel.add (new JLabel ("Enter value Y"));
		yField = new JTextField(5);
		drawPanel.add(yField);
		
		drawPanel.add (new JLabel ("Enter value radius"));
		nField = new JTextField(5);
		drawPanel.add(nField);
		
		buttonPanel.add(drawPanel);
		
		JButton drawButton = new JButton("Draw");
		drawButton.addActionListener(this);
		buttonPanel.add(drawButton);
		
		return buttonPanel;
	}
		
	public void actionPerformed (ActionEvent event)
	{
		int x;
		String xText = xField.getText();
		if (xText.equals(""))
			{
				x = 0;
			}
		else
			{
				x = Integer.parseInt(xText);
			}
		
		int y;
		String yText = yField.getText();
		if (yText.equals(""))
			{
				y = 0;
			}
		else
			{
				y = Integer.parseInt(yText);
			}
				
		int n;
		String nText = nField.getText();
		if (nText.equals(""))
			{
				n = 0;
			}
		else
			{
				n = Integer.parseInt(nText);
			}
				
		shape.setValue(x, y, n);
		repaint();
	}	
		
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("Circle with center radius");
		
		CircleCenterRadiusViewer component = new CircleCenterRadiusViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension (800, 800));
		frame.setVisible(true);		
	}	
}
