//Chapter5 - Exercise P5.3
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TwelveStringColorViewer
{
	public static void main (String[] args)
	{
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
	frame.setTitle("Twelve line in different color");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	TwelveStringColor lineColor = new TwelveStringColor();
	frame.add(lineColor);
	frame.setVisible(true);
	}
}