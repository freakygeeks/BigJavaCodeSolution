//Chapter7 - Exercise P7.8

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RandomCircleTester
{
	public static void main (String[] args)
	{
	final int WIDTH = 400;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
		
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Random Circle");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input = JOptionPane.showInputDialog("Enter number of circle to be draw");
	int x = Integer.parseInt(input);
	
	RandomCircle comp = new RandomCircle(x);
	frame.add(comp);
	frame.setVisible(true);
	}
}
	