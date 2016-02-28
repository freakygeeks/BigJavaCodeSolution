//Chapter2
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;

public class KalerRed
{
	public static void main (String[] args)
	{
	//Color c = new Color(255,0,0);
	//c.darker();
	
	JFrame frame = new JFrame();
	frame.setSize(300,400);
	
	JTextField text = new JTextField("This is a darken RED Color");
	//text.setBackground(c.darker());
	text.setBackground(Color.RED.darker());
	
	frame.add(text);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}