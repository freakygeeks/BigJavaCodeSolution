//Chapter5 - Exercise P5.4
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CircleRadiusViewer
{
	public static void main (String[] args)
	{
	final int WIDTH_FRAME = 600;
	final int HEIGHT_FRAME = 700;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH_FRAME, HEIGHT_FRAME);
	frame.setTitle("Circle with radius value enter by user");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input;
	
	input = JOptionPane.showInputDialog("Please enter the circle radius value");
	double inRadius = Double.parseDouble(input);
	
	CircleRadius comp = new CircleRadius(inRadius);
	frame.add(comp);
	frame.setVisible(true);
	}
}
	
	