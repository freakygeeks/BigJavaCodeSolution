//Chapter8 - Exercise P8.9

import javax.swing.JFrame;

public class PolygonPerimeterAreaViewer
{
	public static void main (String[] args)
	{
	JFrame frame = new JFrame();
	
	final int WIDTH = 500;
	final int HEIGHT = 500;
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Square and Pentagon");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	PolygonPerimeterAreaComponent calc = new PolygonPerimeterAreaComponent();
	frame.add(calc);
	frame.setVisible(true);
	}
}