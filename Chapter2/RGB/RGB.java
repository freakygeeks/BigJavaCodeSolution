//Chapter2 - Exercise P2.5 & P2.6
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;

public class RGB
{
	public static void main (String[] args)
	{
	Color c = new Color(50, 100, 150);
	
	//this is the brighter version
	JFrame frame1 = new JFrame();
	frame1.setSize(400,400);
	
	JTextField text1 = new JTextField("The brighter version");
	text1.setBackground(c.brighter());
	
	frame1.add(text1);
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setVisible(true);
	
	/*-----------------------------------------*/
	
	//this is the darker version
	JFrame frame2 = new JFrame();
	frame2.setSize(400,400);
	
	JTextField text2 = new JTextField("The darker version");
	text2.setBackground(c.darker());
	
	frame2.add(text2);
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.setVisible(true); 
	}
}