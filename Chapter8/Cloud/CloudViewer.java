//Chapter8 - Exercise P8.7

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CloudViewer//get user input for cloud and transfer data to CloudComponent.java
{
	public static void main (String[] args)
	{
	final int WIDTH = 600;
	final int HEIGHT = 600;
	
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Cloud of Ellipse");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input = JOptionPane.showInputDialog("Please enter number for Ellipse");
	int num = Integer.parseInt(input);
	
	CloudComponent calc = new CloudComponent(num);
	frame.add(calc);
	frame.setVisible(true);	
	}
}