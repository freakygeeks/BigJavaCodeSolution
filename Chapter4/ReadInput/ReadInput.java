//Chapter4 - Advanced Topic 4.7
import javax.swing.JOptionPane;

public class ReadInput
{
	public static void main (String[] args)
	{
	String input = JOptionPane.showInputDialog("Enter price : ");
	double price = Double.parseDouble(input);
	System.exit(0);
	}
}