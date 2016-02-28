//Chapter 16 - Project 16.1

import javax.swing.JFrame;

public class CarTester
{
	public static void main (String[] args)
	{
		JFrame frame = new CarFrame();
		frame.setTitle ("Car shape using serialization");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}