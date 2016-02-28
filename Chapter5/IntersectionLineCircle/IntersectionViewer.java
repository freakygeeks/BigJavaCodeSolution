//Chapter5 - Example 5.7

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class IntersectionViewer
{
	public static void main (String[] args)
	{
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 400;
	
	JFrame frame = new JFrame();
	frame.setSize (FRAME_WIDTH, FRAME_HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input = JOptionPane.showInputDialog("Enter x");
	double x = Double.parseDouble(input);
	IntersectionComponent comp = new IntersectionComponent(x);
	
	frame.add(comp);
	frame.setVisible(true);
	}
}