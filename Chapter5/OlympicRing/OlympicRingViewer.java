//Chapter5 - Exercise P5.14
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OlympicRingViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 800;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Olympic Ring");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	OlympicRing comp = new OlympicRing();
	
	frame.add(comp);
	frame.setVisible(true);
	}
}
	
	