//Chapter4 - Exercise P4.9
public class SodaCan
{
	public static final double PIE = 3.142;
	private double radius;
	private double height;
	
	public SodaCan()
	{
	radius = 0;
	height = 0;
	}
	
	public void insert (double rad, double hei)
	{
	this.radius = this.radius + rad;
	this.height = this.height + hei;
	}
	
	public double getVolume()
	{
	double volume = (double)(PIE*Math.pow(radius,2)*height);
	return volume;
	}
	
	public double getArea()
	{
	double area = (double)((2*PIE*Math.pow(radius,2))+(2*PIE*radius*height));
	return area;
	}
}