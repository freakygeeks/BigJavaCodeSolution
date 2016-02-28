//Chapter5 - Exercise P5.13
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PieChartViewer 
{
	public static void main (String[] args)
	{
	final int WIDTH = 600;
	final int HEIGHT = 500;
	
	JFrame frame = new JFrame();
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Plotting Pie Chart");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	PieChart comp = new PieChart();
	
	frame.add(comp);
	frame.setVisible(true);
	}
}