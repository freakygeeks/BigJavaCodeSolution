//Chapter 9 - Example 9

import javax.swing.JOptionPane;

public class GreeterTest
{
	public static void main(String[] args)
	{
		String name = JOptionPane.showInputDialog("Please enter your name:");
		String adjective = JOptionPane.showInputDialog("Please enter an adjective describing yourself:");

		Greeter g = new Greeter(name, adjective);
		g.getGreeting();

		System.exit(0);
	}
}
