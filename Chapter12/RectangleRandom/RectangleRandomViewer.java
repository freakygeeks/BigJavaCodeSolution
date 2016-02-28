//Chapter 12 - Exercise 12.11

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

public class RectangleRandomViewer extends JComponent implements ActionListener 
{
	private JTextField nField;
	private RectangleRandom shape;
	

	public RectangleRandomViewer() 
	{
		shape = new RectangleRandom();
	}
	
	public void paintComponent (Graphics g) 
	{
		super.paintComponent(g);
		shape.paint(g);
	}
	
	private Component createControlPanel() 
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout (new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
		
		JPanel translatePanel = new JPanel();
		translatePanel.add (new JLabel ("Enter Rectangle Number "));
		nField = new JTextField(5);
		translatePanel.add(nField);
		buttonPanel.add(translatePanel);
		
		JButton applyButton = new JButton ("Draw");
		applyButton.addActionListener(this);
		buttonPanel.add(applyButton);
		
		return buttonPanel;
	}

	public void actionPerformed(ActionEvent event) 
	{		
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
		
		shape.setValue(n);
		repaint();
	}

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		frame.setTitle("Random Rectangle");
		
		// Create the display
		RectangleRandomViewer axes = new RectangleRandomViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(axes, BorderLayout.CENTER);
		contentPane.add(axes.createControlPanel(), BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800, 800));
		frame.setVisible(true);
	}
}