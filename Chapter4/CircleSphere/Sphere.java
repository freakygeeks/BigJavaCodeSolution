//Chapter4 - Exercise P4.8
public class Sphere
{
	public static final double PIE = 3.142;
	private double radius;
	
	public Sphere()
	{
	radius = 0;
	}
	
	public void insert (double rad)
	{
	this.radius = this.radius + rad;
	}
	
	public double getVolume()
	{
	double volume = (double)((4/3)*PIE*Math.pow(radius,3));
	return volume;
	}
	
	public double getSurface()
	{
	double surface = (double)(4*PIE*Math.pow(radius,2));
	return surface;
	}
}