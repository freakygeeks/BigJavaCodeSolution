//Chapter7 - Exercise P7.4

public class CannonBall
{
	private double v;
	private double n;
	private double i;
	private double r;
	private double x;
	private double y;
	private double count;
	private final double VALUE = -0.5;
	private final double GRAVITY = 9.81;
	
	CannonBall()
	{
	v = 0;
	n = 0;
	i = 0;
	r = 0;
	x = 0;
	y = 0;
	count = 0;
	}
	
	public void calcVelocity (double velocity, double radian)
	{
	v = v + velocity;
	r = r + radian;	
	
	for (i = v; i > 0; i = i - GRAVITY)
		{
		count++;
		
		if (count == 1)
			{
			n = VALUE*GRAVITY*count + i*count;
			x = i*Math.cos(r);
			y = i*Math.sin(r);
			}
		else if (count > 1)
			{
			n = VALUE*GRAVITY*count + i*count - GRAVITY;
			x = i*Math.cos(r);
			y = i*Math.sin(r);
			}
		System.out.println ("Updated Velocity Value : " + i); 
		System.out.println ("Updated Formula Position Value : " + n);
		System.out.println ("Location of X : " + x + " and Y " + y);
		System.out.println ();
		}
	}
	
	public double getCount()
	{
	return count;
	}
}