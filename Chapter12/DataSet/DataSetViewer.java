//Chapter 12 - Exercise 12.10

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataSetViewer
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 300;
	
	public static void main (String[] args)
	{
		final int FIELD = 10;
		
		JFrame frame = new JFrame();
		
		//for 1st values
		JLabel numOne = new JLabel ("First number");
		final JTextField numOneField = new JTextField(FIELD);
		numOneField.setText(" ");
		
		//for 2nd values
		JLabel numTwo = new JLabel ("Second number");
		final JTextField numTwoField = new JTextField(FIELD);
		numTwoField.setText(" ");
		
		//for 3rd values
		JLabel numThree = new JLabel ("Third number");
		final JTextField numThreeField = new JTextField(FIELD);
		numThreeField.setText(" ");
	
		//for 4th values
		JLabel numFour = new JLabel ("Fourth number");
		final JTextField numFourField = new JTextField(FIELD);
		numFourField.setText(" ");
		
		//button to enter
		JButton dataButton = new JButton ("Enter");
		
		final DataSet calc = new DataSet();
		
		final JLabel min = new JLabel ("Minimum number : ");
		final JLabel max = new JLabel ("Maximum number : ");
		final JLabel sum = new JLabel ("Sum of number : ");
		final JLabel ave = new JLabel ("Average number : ");
		
		JPanel panel = new JPanel();
		panel.add(numOne);
		panel.add(numOneField);
		panel.add(numTwo);
		panel.add(numTwoField);
		panel.add(numThree);
		panel.add(numThreeField);
		panel.add(numFour);
		panel.add(numFourField);
		panel.add(dataButton);
		panel.add(min);
		panel.add(max);
		panel.add(sum);
		panel.add(ave);
		frame.add(panel);
		
		//listener for dataSet
		class DataSetListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double one = Double.parseDouble(numOneField.getText());
				calc.addValue(one);
				
				double two = Double.parseDouble(numTwoField.getText());
				calc.addValue(two);
				
				double three = Double.parseDouble(numThreeField.getText());
				calc.addValue(three);
				
				double four = Double.parseDouble(numFourField.getText());
				calc.addValue(four);
				
				min.setText("Minimum number : " + calc.getSmallest());
				max.setText("Maximum number : " + calc.getLargest());		
				sum.setText("Sum of number : " + calc.getSum());
				ave.setText("Average number : " + calc.getAverage());
			}		
		}
		
		//callback listener
		DataSetListener listener = new DataSetListener();
		dataButton.addActionListener(listener);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}