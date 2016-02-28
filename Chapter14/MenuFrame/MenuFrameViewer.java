//Chapter 14 - Example 14.4

import javax.swing.JFrame;

public class MenuFrameViewer
{
	public static void main (String[] args)
	{
		JFrame frame = new MenuFrame();
		frame.setTitle("Menu Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}