//Chapter 14 - Example 14.6

import javax.swing.JFrame;

public class SliderFrameViewer
{
	public static void main (String[] args)
	{
		SliderFrame frame = new SliderFrame();
		frame.setTitle("Slider Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}