//Chapter 23 - Exercise 23.5

import java.awt.Dimension;

public class SmartCarThread extends CarThread
{
	private Dimension d;
	
	public SmartCarThread (double x, double y, double speed, Dimension aDim)
	{
		super(x, y, speed);
		d = aDim;
	}
	
	public void move()
	{
		if (getX() <= 0 || getX() >= d.getWidth() - 60)
		{
			reverseDirection();
		}
		super.move();
	}
	
	public void reverseDirection()
	{
		setSpeed(-getSpeed());
	}
}















