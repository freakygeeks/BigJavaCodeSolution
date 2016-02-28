//Chapter7 - Exercise P7.7 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckerBoardViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 410;
	final int HEIGHT = 440;
	
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Checkerboard");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	CheckerBoard comp = new CheckerBoard();
	frame.add(comp);
	frame.setVisible(true);
	}
}