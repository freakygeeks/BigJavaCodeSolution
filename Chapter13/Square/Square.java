//Chapter 13 - Exercise 13.3

import java.awt.Rectangle;

public class Square extends Rectangle
{
	public Square (int x, int y, int w) //x, y coordinate, w side length
	{
		setLocation(x - w/2, y - w/2);
		setSize(w, w);
	}
	
	public double getArea()
	{
		return getWidth()*getWidth();
	}
}