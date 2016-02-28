//Chapter8 - Exercise P8.8

import javax.swing.JFrame;

public class PolygonViewer
{
	public static void main (String[] args)
	{
	JFrame frame = new JFrame();
	
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Square and Pentagon");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	PolygonComponent calc = new PolygonComponent();
	frame.add(calc);
	frame.setVisible(true);
	}
}