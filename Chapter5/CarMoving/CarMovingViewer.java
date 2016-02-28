//Chapter5 - Exercise P5.15
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CarMovingViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 700;
	final int HEIGHT = 700;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Car Moving");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	CarMoving comp1 = new CarMoving(0, 0, Color.RED);
	CarMoving comp2 = new CarMoving(80, 85, Color.RED);
	
	frame.add(comp1);
	frame.setVisible(true);
	
	frame.add(comp2);
	frame.setVisible(true);
	}
}