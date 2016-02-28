//Chapter4 - Exercise P4.8
public class Circle
{
	public static final double PIE = 3.142;
	private double radius;
	
	public Circle()
	{
	radius = 0;
	}
	
	public void insert (double rad)
	{
	this.radius = this.radius + rad;
	}
	
	public double getArea()
	{
	double area = (double)(PIE*Math.pow(radius,2));
	return area;
	}
	
	public double getCircumference()
	{
	double circumference = (double)(PIE*radius*2);
	return circumference;
	}
}