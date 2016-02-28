//Chapter7 - Exercise P7.3 - http://horstmann.com/labrat/demo/ch6_programming.html

public class ProjectileFlight
{
	private double v;
	private double n;
	private double i;
	private double count;
	private final double GRAVITY = 9.81;
	private final double VALUE = -0.5;
		
	ProjectileFlight()
	{
	v = 0;
	n = 0;
	i = 0;
	count = 0;
	}
	
	public void calcVelocity(double velocity)
	{
	v = v + velocity;
	
	for (i = v; i > 0; i = i - GRAVITY)
		{
		count++;
		
		if (count == 1)
			{
			n = VALUE*GRAVITY*count + i*count;
			}
		else if (count > 1 )
			{
			n = VALUE*GRAVITY*count + i*count - GRAVITY;
			}
		System.out.println ("Updated Velocity Value : " + i); 
		System.out.println ("Updated Formula Position Value : " + n);
		System.out.println ();
		}
	}
	
	public double getCount()
	{
	return count;
	}
}

	
	
