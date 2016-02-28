//Chapter 18 - Project 18.2

import javax.swing.JFrame;

public class TowerTester
{
	public static void main (String[] args)
	{
		JFrame frame = new TowerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tower of Hanoi");
		frame.setVisible(true);
		frame.show();
	}
}