//Chapter5 - Example 5.5 & Exercise P5.16
import javax.swing.JFrame;

public class CarComponentViewer
{
	public static void main (String[] args)
	{
	JFrame frame = new JFrame();
	
	final int FRAME_WIDTH = 700;
	final int FRAME_HEIGHT = 700;
	
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setTitle("Two Car Pictures");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	CarComponent component = new CarComponent();
	frame.add(component);
	
	frame.setVisible(true);
	}
}