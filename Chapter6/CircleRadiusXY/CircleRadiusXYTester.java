//Chapter6 - Exercise P6.5

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CircleRadiusXYTester
{
	public static void main (String[] args)
	{
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Circle Radius Point X and Y");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input1 = JOptionPane.showInputDialog("Enter X");
	double x = Double.parseDouble(input1);
	
	String input2 = JOptionPane.showInputDialog("Enter Y");
	double y = Double.parseDouble(input2);
	
	CircleRadiusXY comp = new CircleRadiusXY(x,y);
	
	/*if (comp.isInside() == false)
		{
		JOptionPane.showMessageDialog(null, "Congratulation!", "Yay!", JOptionPane.ERROR_MESSAGE);
		//JOptionPane.showMessageDialog(null, "You missed!", "Ouch!", JOptionPane.ERROR_MESSAGE);
		}
	else*/
	frame.add(comp);
	frame.setVisible(true);
	}
}
	
	