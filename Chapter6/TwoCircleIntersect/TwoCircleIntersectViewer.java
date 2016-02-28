//Chapter6 -  Exercise 6.6

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TwoCircleIntersectViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 500;
	final int HEIGHT = 500;
	
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Cubajaya intersection dua bulatan ok!");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	/*String input = JOptionPane.showInputDialog("Please enter coordinate for first X");
	double x1 = Double.parseDouble(input);
	
	String input2 = JOptionPane.showInputDialog("Please enter coordinate for first Y");
	double y1 = Double.parseDouble(input2);*/
	
	String input3 = JOptionPane.showInputDialog("Please enter radius for first circle");
	double r1 = Double.parseDouble(input3);
	
	/*String input4 = JOptionPane.showInputDialog("Please enter coordinate for second X");
	double x2 = Double.parseDouble(input4);
	
	String input5 = JOptionPane.showInputDialog("Please enter coordinate for second Y");
	double y2 = Double.parseDouble(input5);*/
	
	String input6 = JOptionPane.showInputDialog("Please enter radis for second circle");
	double r2 = Double.parseDouble(input6);
	
	TwoCircleIntersect calc = new TwoCircleIntersect(r1, r2);
	frame.add(calc);
	frame.setVisible(true);
	}
}