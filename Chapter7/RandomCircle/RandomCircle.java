//Chapter7 - Exercise P7.8

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;
import java.util.Random;

public class RandomCircle extends JComponent
{
	private double x;
	private double y;
	private int n;
	private Random gen;
	
	RandomCircle(int num)
	{
	x = 50;
	y = 50;
	n = num;
	gen = new Random();
	}
	
	public void paintComponent(Graphics g)
	{
	final double WIDTH = 100;
	final double HEIGHT = 100;
	
	Graphics2D g2 = (Graphics2D) g;
		
	for (int i = 0; i < n; i++)
		{
		double aX = x*gen.nextDouble();
		double aY = y*gen.nextDouble();
		double aWidth = WIDTH*gen.nextDouble();
		
		Ellipse2D.Double circle = new Ellipse2D.Double (aX+i*5, aY+i*10, aWidth+i, HEIGHT+i);
		g2.setColor(Color.BLUE);
		g2.fill(circle);
		g2.draw(circle);
		}
	}
}