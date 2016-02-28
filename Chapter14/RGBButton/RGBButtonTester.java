//Chapter 14 - Exercise 14.1

import javax.swing.JFrame;

public class RGBButtonTester
{
	public static void main (String[] args)
	{
		JFrame frame = new RGBButton();
		
		frame.setTitle("RGB Button Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}