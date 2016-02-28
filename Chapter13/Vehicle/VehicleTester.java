//Chapter 13 - Exercise 13.7

import javax.swing.JFrame;

public class VehicleTester
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		frame.setTitle ("Animation Inheritence : Car and Trunk");
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		VehicleAnimation panel = new VehicleAnimation();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}