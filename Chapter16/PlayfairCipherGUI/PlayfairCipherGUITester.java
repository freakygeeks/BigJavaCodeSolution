//Chapter 16 - Exercise 16.12

import javax.swing.JFrame;

public class PlayfairCipherGUITester
{
	public static void main (String[] args)
	{
		JFrame frame = new PlayfairCipherGUIFrame();
		frame.setTitle("Playfair Cipher with GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}