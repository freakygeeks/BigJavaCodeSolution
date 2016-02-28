//Chapter 12 - Exercise 12.19

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class NByNGrid
{
	private int c; //user input
	private int x;
	private int y;
	private int xC;
	private int yC;
	private int xA = 100; //start at x = 100
	private int yA = 100;
	private int xB = 600;
	private int yB = 600;
	private int j = 500;  //jarak
		
	public void setCount (int aC)
	{
		c = aC;
	}
	
	public void getCount()
	{		
		xC = (int) j/c;
		yC = (int) j/c;
	}
		
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
				
		for (int i = 1; i < c; i++)
			{
				Line2D.Double horizontalTop = new Line2D.Double (xA, yA, xA+j,yA);
				Line2D.Double horizontalBelow = new Line2D.Double (xA, yA+j, xB, yB);
				Line2D.Double columnLeft = new Line2D.Double (xA, yA, xA, yA+j);
				Line2D.Double columnRight = new Line2D.Double (xA+j, yA, xB, yB);
				g2.draw(horizontalTop);
				g2.draw(horizontalBelow);
				g2.draw(columnLeft);
				g2.draw(columnRight);	
			
				x = 100 + xC*i;
				y = 100 + yC*i;
				Line2D.Double gridColumn = new Line2D.Double (x, yA, x, yB);	
				Line2D.Double gridHorizontal = new Line2D.Double (xA, y, xB, y);					
				g2.draw(gridColumn);			
				g2.draw(gridHorizontal);
			}	

	}
}