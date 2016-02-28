//Chapter 14 - Exercise 14.10

import javax.swing.JFrame;

public class BankTextAreaTester
{
		private static final int WIDTH = 600;
		private static final int HEIGHT = 650;
		
	public static void main (String[] args)
	{
		JFrame frame = new BankTextAreaFrame();
		frame.setTitle("Bank Text Area Frame");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}	
}