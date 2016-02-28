//Chapter5 - Exercise P5.12
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BarChartViewer
{
	public static void main (String[] args)
	{
	final int WIDTH = 900;
	final int HEIGHT = 400;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Bar Chart Plotting");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	BarChart comp = new BarChart();
	frame.add(comp);
	frame.setVisible(true);
	}
}