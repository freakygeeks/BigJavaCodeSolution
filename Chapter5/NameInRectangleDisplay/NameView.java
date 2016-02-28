//Chapter5 - Exercise P5.2
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NameView
{
	public static void main (String[] args)
	{
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setTitle("Red name in blue rectangle with popup");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input;
	
	input = JOptionPane.showInputDialog("Please enter your name");
	String inputName = input;
	
	NameComp comp = new NameComp(inputName);
	frame.add(comp);
	frame.setVisible(true);
	}
}