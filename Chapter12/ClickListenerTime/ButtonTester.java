//Chapter 12 - Exercise 12.5

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Date;

public class ButtonTester
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;

	public static void main (String[] args)
	{	
	final int DELAY = 100;
	
	JFrame frame = new JFrame();
	
	JButton button1 = new JButton("Button A - Click Me");
	JButton button2 = new JButton("Button B - Click Me");
	
	JPanel panel = new JPanel();
	panel.add(button1);
	panel.add(button2);
	frame.add(panel);
	
	class AddButtonAB implements ActionListener
	{
		int count = 0;
		
		public void actionPerformed (ActionEvent event)
		{
			if (event.getSource() == button1)
				{
				count++;
				Date now = new Date();
				System.out.println ("Button A was clicked " + count + " times at " + now );
				}
			else if (event.getSource() == button2)
				{
				count++;
				Date now = new Date();
				System.out.println ("Button B was clicked " + count + " times at " + now);
				}
		}
	}
	
	ActionListener listener1 = new AddButtonAB();
	button1.addActionListener(listener1);
	button2.addActionListener(listener1);
	
	Timer t = new Timer (DELAY, listener1);
	t.start();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}