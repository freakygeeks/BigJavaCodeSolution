//Chapter5 - Exercise P5.8 & P5.9
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateHouseViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 300;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Creating simple house");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	CreateHouse comp = new CreateHouse();
	frame.add(comp);
	frame.setVisible(true);
	}
}