//Chapter 18 - Project 18.2

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Tower
{
	private ArrayList disk;
	private Rectangle bounds;
	
	public Tower(Rectangle b)
	{
		disk = new ArrayList();
		bounds = b;
	}
	
	public void addDisk (Rectangle d)
	{
		disk.add(d);
	}
	
	public Rectangle removeDisk()
	{
		return (Rectangle)disk.remove(disk.size()-1);
	}
	
	public void draw (Graphics2D g2)
	{
		double height = 0;
		g2.draw(bounds);
		
		for  (int i = 0; i < disk.size(); i++)
		{
			Rectangle r = (Rectangle)disk.get(i);
			r.translate((int)(bounds.getCenterX() - r.getCenterX()), (int)(bounds.getMaxY() -  height - r.getMaxY()));
			g2.fill(r);
			height = height + r.getHeight();
		}
	}
}

















