//Chapter5 - Example 5.6
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ColorViewer
{
	public static void main (String[] args)
	{
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 400;
	
	JFrame frame = new JFrame();
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String input;
	
	input = JOptionPane.showInputDialog("red");
	double red = Double.parseDouble(input);
	
	input = JOptionPane.showInputDialog("green");
	double green = Double.parseDouble(input);
	
	input = JOptionPane.showInputDialog("blue");
	double blue = Double.parseDouble(input);
	
	Color fillColor = new Color ((float) red, (float) green, (float) blue);
	
	ColorSquareComponent comp = new ColorSquareComponent(fillColor);
	frame.add(comp);
	frame.setVisible(true);
	}
}