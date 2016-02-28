//Chapter7 - Exercise P7.9

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class Spiral extends JComponent
{
	private double x;
	private double y;
	private double len;
	
	Spiral()
	{
	x = 200;
	y = 200;
	len = 12.5;
	}
	
	public void paintComponent (Graphics g)
	{	
	Graphics2D g2 = (Graphics2D) g;
	
	for (int i = 0; i < 9; i++)
	{
	Line2D.Double bottom = new Line2D.Double (x, y, x+len, y);
	Line2D.Double right = new Line2D.Double (x+len*i, y, x+len*i, y-len*i);
	Line2D.Double top = new Line2D.Double (x+len*i, y-len*i, x-len*i, y-len*i);
	Line2D.Double left = new Line2D.Double (x-len*i, y-len*i, x-len*i, y+len*i);
	Line2D.Double aBottom = new Line2D.Double (x-len*i, y+len*i, x+len*(i+1), y+len*i);
	Line2D.Double aRight = new Line2D.Double (x+len*(i+1), y+len*i, x+len*(i+1), y);
	
	g2.setColor(Color.BLUE);
	g2.draw(bottom);
	
	g2.setColor(Color.RED);
	g2.draw(right);
	
	g2.setColor(Color.BLACK);
	g2.draw(top);
	
	g2.setColor(Color.GREEN);
	g2.draw(left);
		
	g2.setColor(Color.BLUE);
	g2.draw(aBottom);
	
	g2.setColor(Color.RED);
	g2.draw(aRight);
	}
	}
}