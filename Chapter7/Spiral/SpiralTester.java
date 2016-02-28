//Chapter7 - Exercise P7.9

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SpiralTester
{
	public static void main (String[] args)
	{
	final int WIDTH = 500;
	final int HEIGHT = 500;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Spiral3");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Spiral comp = new Spiral();
	
	frame.add(comp);
	frame.setVisible(true);
	}
}
	