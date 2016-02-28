//Chapter 12 - Exercise 12.1

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonTester
{
	private static final int WIDTH = 100;
	private static final int HEIGHT = 60;

	public static void main (String[] args)
	{
	JFrame frame = new JFrame();
	JButton button = new JButton("Click Me");
	frame.add(button);
	
	ActionListener listener = new ClickListener();
	button.addActionListener(listener);
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}