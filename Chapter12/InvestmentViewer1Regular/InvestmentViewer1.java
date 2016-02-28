//Chapter 12 - Exercise 12.6

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class InvestmentViewer1
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 100;
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		JButton button = new JButton("Add Interest");
		frame.add(button);
		
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}