//Chapter5 - Exercise P5.7
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CircleResizeWindowViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Circle resize with window resizing");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	CircleResizeWindow comp = new CircleResizeWindow();
	frame.add(comp);
	frame.setVisible(true);
	}
}