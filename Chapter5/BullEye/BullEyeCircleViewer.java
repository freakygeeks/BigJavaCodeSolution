//Chapter5 - Exercise P5.6
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BullEyeCircleViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Layers of Colorful BullEye");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	BullEyeCircle comp = new BullEyeCircle();
	frame.add(comp);
	frame.setVisible(true);
	}
}