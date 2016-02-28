//Chapter 9 - Exercise 9.9

import javax.swing.JOptionPane;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

public class EllipseIsInsideTester
{
	public static void main (String[] args)
	{
		String input = JOptionPane.showInputDialog("Please enter the width of the ellipse:");
		double w = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please enter the height of the ellipse:");
		double h = Double.parseDouble(input);
		Ellipse2D.Double e = new Ellipse2D.Double(0, 0, w, h);

		input = JOptionPane.showInputDialog("Please enter the x-coordinate of the point:");
		double x = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please enter the y-coordinate of the point:");
		double y = Double.parseDouble(input);
		Point2D.Double p = new Point2D.Double(x, y);

		System.out.print("The point is ");
		if (!EllipseIsInside.isInside(p, e))
		{
			System.out.print("not ");
		}
		
		System.out.println("inside the ellipse.");
		System.exit(0);
	}
}