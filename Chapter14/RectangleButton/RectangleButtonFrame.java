//Chapter 14 - Exercise 14.8

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

public class RectangleButtonFrame extends JComponent 
{
	private RectangleButtonPanel shape;
	private JButton fewerButton;
	private JButton moreButton;
	private int n = 50;

	public RectangleButtonFrame() 
	{
		shape = new RectangleButtonPanel();
	}
	
	public void paintComponent (Graphics g) 
	{
		super.paintComponent(g);
		shape.paint(g);
	}
	
	public Component createControlPanel() 
	{
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		fewerButton = new JButton ("Fewer");
		moreButton = new JButton ("More");
		
		class FewerListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				n = n/2;
				shape.setNumber(n);
				repaint();
			}
		}
		
		class MoreListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				n = n*2;
				shape.setNumber(n);
				repaint();
			}
		}
		
		FewerListener listener1 = new FewerListener();
		fewerButton.addActionListener(listener1);
		
		MoreListener listener2 = new MoreListener();
		moreButton.addActionListener(listener2);
		
		buttonPanel.add(fewerButton);
		buttonPanel.add(moreButton);
		
		return buttonPanel;
	}
}