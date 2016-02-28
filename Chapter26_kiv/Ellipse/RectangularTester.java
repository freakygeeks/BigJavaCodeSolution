//Chapter 26 - Exercise 26.9

import javax.swing.JFrame;
import java.awt.Shape;

public class RectangularTester
{
	public static void main (String[] args) throws Exception
	{
		RectangularShapeParser rp = new RectangularShapeParser();
		Shape s = rp.parse("rectangularshape.xml");
		RectangularPanel rectPanel = new RectangularPanel(s);
		
		JFrame appFrame = new JFrame();
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setContentPane(rectPanel);
		appFrame.pack();
		appFrame.show();
	}
}