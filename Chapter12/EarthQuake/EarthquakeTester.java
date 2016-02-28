//Chapter 12 - Exercise 12.9

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EarthquakeTester
{
	private static final double INITIAL_VALUE = 0;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 100;
	
	public static void main (String[] args)
	{
		final int FIELD_WIDTH = 10;

		JFrame frame = new JFrame();

		//for deposit money text
		JLabel earthLabel = new JLabel ("Earth Quake Strength");
		final JTextField earthField = new JTextField(FIELD_WIDTH);
		earthField.setText(" ");
		
		//for deposit money
		JButton earthButton = new JButton ("Enter");
	
		//for inital balance account
		final Earthquake calc = new Earthquake(INITIAL_VALUE);
		final JLabel resultLabel = new JLabel ("Strength Description : ");
	
		JPanel panel = new JPanel();
		panel.add(earthLabel);
		panel.add(earthField);
		panel.add(earthButton);
		panel.add(resultLabel);
		frame.add(panel);
		
		//listener class for deposit money
		class EarthQuakeListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double quake = Double.parseDouble(earthField.getText());
				calc.getStrength(quake);
			
				resultLabel.setText("Strength Description : " + calc.getDescription());
			}
		}		
		
		//callback listener for deposit
		EarthQuakeListener listener = new EarthQuakeListener();
		earthButton.addActionListener(listener);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}