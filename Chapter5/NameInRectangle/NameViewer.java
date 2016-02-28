//Chapter5 - Exercise P5.1
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NameViewer
{
	public static void main (String[] args)
	{
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setTitle("Red name in a blue rectangle");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	NameComponent comp = new NameComponent();
	frame.add(comp);
	frame.setVisible(true);
	}
}