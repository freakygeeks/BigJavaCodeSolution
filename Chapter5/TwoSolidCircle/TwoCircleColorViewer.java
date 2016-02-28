//Chapter5 - Exercise P5.5
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TwoCircleColorViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Two solid circle with color");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	TwoCircleColor appear = new TwoCircleColor();
	frame.add(appear);
	frame.setVisible(true);
	}
}