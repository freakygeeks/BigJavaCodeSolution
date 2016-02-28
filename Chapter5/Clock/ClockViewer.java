//Chapter5 - Project 5.1
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClockViewer 
{
	public static void main (String[] args)
	{
	final int WIDTH = 700;
	final int HEIGHT = 700;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Clock based on Gregorian Calendar");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Clock comp = new Clock();
	
	frame.add(comp);
	frame.setVisible(true);
	}
}