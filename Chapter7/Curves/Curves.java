//Chapter7 - Exercise P7.17

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class Curves extends JComponent
{
	private double n;
	private double x;
	private double y;
	private double d;
	private double dX;
	private double dY;
	
	Curves()
	{
	n = 400;
	x = 0;
	y = 400;
	d = 400/100;
	dX = 0;
	dY = 0;
	}
	
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;

	for (double i = 0; i <= n; i++)
		{
		x = i;
		y = y + i;
		dX = x + d;
		dY = (0.00005*Math.pow(x,3))-(0.03*Math.pow(x,2))+(4*x)+200;
		
		Line2D.Double curve = new Line2D.Double (x, y, dX, dY);
		g2.setColor(Color.GREEN);
		g2.draw(curve);
		
		//dY = Math.pow(x,3)-(x)+10;
		//System.out.println ("x : " + x + " , y : " + y + " , dX : " + dX + " , dY : " + dY);
		//System.out.println ("d : " + d);
		}
	}
}