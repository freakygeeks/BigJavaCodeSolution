//Chapter 12 - Exercise 12.2

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTester
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;

	public static void main (String[] args)
	{
	JFrame frame = new JFrame();
	
	JButton button1 = new JButton("Button One - Click Me");	
	JButton button2 = new JButton("Button Two - Click Me");
	
	ActionListener listener1 = new ClickListener();
	button1.addActionListener(listener1);
	
	ActionListener listener2 = new ClickListener();
	button2.addActionListener(listener2);
	
	JPanel panel = new JPanel();
	panel.add(button1);
	panel.add(button2);
	frame.add(panel);
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}