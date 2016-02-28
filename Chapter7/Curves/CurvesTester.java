//Chapter7 - Exercise P7.17

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CurvesTester
{
	public static void main (String[] args)
	{
	final int WIDTH = 410;
	final int HEIGHT = 450;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Graph of Curves");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Curves calc = new Curves();
	frame.add(calc);
	frame.setVisible(true);
	}
}