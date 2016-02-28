//Chapter7 - Exercise P7.18

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FourLeavedRoseTester
{
	public static void main (String[] args)
	{
	final int WIDTH = 510;
	final int HEIGHT = 530;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Four Leaved Rose");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	FourLeavedRose calc = new FourLeavedRose();
	frame.add(calc);
	frame.setVisible(true);
	}
}