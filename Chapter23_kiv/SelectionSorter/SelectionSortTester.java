//Chapter 23 - Example 23.6

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SelectionSortTester
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		
		final int WIDTH = 300;
		final int HEIGHT = 400;
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final SelectionSortComponent comp = new SelectionSortComponent();
		frame.add(comp, BorderLayout.CENTER);
		frame.setVisible(true);
		comp.startAnimation();
	}
}