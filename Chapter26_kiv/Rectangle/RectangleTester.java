//Chapter 26 - Exercise 26.7

import javax.swing.JFrame;
import java.awt.Rectangle;

public class RectangleTester
{
	public static void main (String[] args) throws Exception
	{
		RectangleParser rp = new RectangleParser();
		Rectangle r = rp.parse("rectangle.xml");
		RectanglePanel rectPanel = new RectanglePanel(r);
		
		JFrame appFrame = new JFrame();
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setContentPane(rectPanel);
		appFrame.pack();
		appFrame.show();
	}
}