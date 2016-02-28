//Chapter2 - Project 2.2
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;

public class FrameTester
{
	public static void main (String[] args)
	{
	JFrame frame = new JFrame();
	frame.setSize(400,400);
	
	JTextField text = new JTextField("Hello, Bruniese HB!");
	text.setBackground(Color.GREEN.brighter());
	//text.setBackground (new Color(0,255,0));
	
	frame.add(text);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}