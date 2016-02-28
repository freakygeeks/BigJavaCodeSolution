//Chapter 9 - Exercise 9.7

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import java.awt.geom.Ellipse2D;

public class EllipseHelperTester extends Applet
{
	double w;
	double h;
	
	public void init()
	{
		String input = JOptionPane.showInputDialog("Please enter the width : ");
		w = Double.parseDouble(input);
		
		input = JOptionPane.showInputDialog("Please enter the height : ");
		h = Double.parseDouble(input);
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double e = new Ellipse2D.Double(0, 0, w, h);
		g2.draw(e);
		g2.drawString("Perimeter : " + EllipseHelper.perimeter(e), 100, 260);
		g2.drawString("Area : " + EllipseHelper.area(e), 100, 290);
	}
}


















