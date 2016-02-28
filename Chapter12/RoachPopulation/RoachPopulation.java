//Chapter 12 - Exercise 12.7

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoachPopulation
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	private static final int GROWTH = 2;

	public static void main (String[] args)
	{	
	JFrame frame = new JFrame();
	
	JButton button = new JButton("Roach Growth");
	JLabel result = new JLabel ("Roach population is " + GROWTH);
	
	JPanel panel = new JPanel();
	panel.add(button);
	panel.add(result);
	frame.add(panel);
	
	class RoachGrowth implements ActionListener
	{
		int count = 0;
		int roachGrowth = 2;
		
		public void actionPerformed (ActionEvent event)
		{
				count++;
				roachGrowth = roachGrowth*2;
				result.setText("Roach population growth is " + roachGrowth);
		}
	}
	
	ActionListener listener = new RoachGrowth();
	button.addActionListener(listener);
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}