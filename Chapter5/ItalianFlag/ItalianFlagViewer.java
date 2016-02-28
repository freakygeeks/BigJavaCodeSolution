//Chapter5 - Example How To 5.1
import javax.swing.JFrame;

public class ItalianFlagViewer
{
	public static void main (String[] args)
	{
	JFrame frame = new JFrame();

	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 300;
	
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ItalianFlagComponents component = new ItalianFlagComponents();
	frame.add(component);
	
	frame.setVisible(true);
	}
}