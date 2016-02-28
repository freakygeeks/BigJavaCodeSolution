//Chapter 14 - Exercise 14.3

import javax.swing.JFrame;

public class CalculatorTester
{
	public static void main (String[] args)
	{
		JFrame frame = new Calculator();
		
		frame.setTitle("Calculator Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}