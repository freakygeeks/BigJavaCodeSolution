//Chapter 26 - Exercise 26.11

import javax.swing.JFrame;
import java.util.ArrayList;

public class DrawingTester
{
	public static void main (String[] args) throws Exception
	{
		DrawingParser p = new DrawingParser();
		ArrayList drawingList = p.parse("drawing.xml");
		DrawPanel drawPanel = new DrawPanel(drawingList);
		
		JFrame appFrame = new JFrame();
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setContentPane(drawPanel);
		appFrame.pack();
		appFrame.show();
	}
}