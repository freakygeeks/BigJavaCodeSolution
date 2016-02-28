//Chapter 12 - Exercise 12.4

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
				System.out.println ("Button A was clicked " + count + " times");
				}
			else if (event.getSource() == button2)
				{
				count++;
				System.out.println ("Button B was clicked " + count + " times");
				}
		}
	}
	
	ActionListener listener1 = new AddButtonAB();
	button1.addActionListener(listener1);
	button2.addActionListener(listener1);
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}