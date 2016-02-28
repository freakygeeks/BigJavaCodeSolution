//Chapter6 - Exercise P6.3

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class IntersectionViewer
{
	public static void main (String[] args)
	{
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 400;
	
	JFrame frame = new JFrame();
	frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
	frame.setTitle("Intersection Circle and Line");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input = JOptionPane.showInputDialog("Enter X");
	double x = Double.parseDouble(input);
	
	IntersectionComponent comp = new IntersectionComponent(x);
	frame.add(comp);
	frame.setVisible(true);
	}
}