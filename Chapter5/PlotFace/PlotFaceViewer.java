//Chapter5 - Exercise P5.10
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PlotFaceViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Plot smiley face");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	PlotFace comp = new PlotFace();
	
	frame.add(comp);
	frame.setVisible(true);
	}
}