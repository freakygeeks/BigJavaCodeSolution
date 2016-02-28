//Chapter 14 - Exercise 14.8

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

public class RectangleButtonTester
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		frame.setTitle("Random Rectangle");
		
		// Create the display
		RectangleButtonFrame axes = new RectangleButtonFrame();
		Container contentPane = frame.getContentPane();
		contentPane.add(axes, BorderLayout.CENTER);
		contentPane.add(axes.createControlPanel(), BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800, 800));
		frame.setVisible(true);
	}
}