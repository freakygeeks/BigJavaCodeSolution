//Chapter5 - Exercise P5.11
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LetterHelloViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 600;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Letter HELLO");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	LetterH comp1 = new LetterH();
	frame.add(comp1);
	frame.setVisible(true);
	
	LetterE comp2 = new LetterE();
	frame.add(comp2);
	frame.setVisible(true);
	
	LetterL1 comp3 = new LetterL1();
	frame.add(comp3);
	frame.setVisible(true);
	
	LetterL2 comp4 = new LetterL2();
	frame.add(comp4);
	frame.setVisible(true);
	
	LetterO comp5 = new LetterO();
	frame.add(comp5);
	frame.setVisible(true);	
	}
}