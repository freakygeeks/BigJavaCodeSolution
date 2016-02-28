//Chapter 13 - Exercise 13.3

import javax.swing.JOptionPane;

public class SquareTester
{
	public static void main (String[] args)
	{
		String input = JOptionPane.showInputDialog("x : ");
		int x = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("y : ");
		int y = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("side :");
		int s = Integer.parseInt(input);
		
		Square sq = new Square (x, y, s);
		System.out.println (sq.toString());
		System.out.println ("Area = : " + sq.getArea());
		
		System.exit(0);
	}
}