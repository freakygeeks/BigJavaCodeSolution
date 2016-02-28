//Chapter 9 - Exercise 9.5

public class Geometry
{
	public static double sphereVolume(double r)
	{
		return (4.0/3.0)*Math.PI*r*r*r;
	}
	
	public static double sphereSurface(double r)
	{
		return 4.0*Math.PI*r*r;
	}
	
	public static double cylinderVolume(double r, double h)
	{
		return h*Math.PI*r*r;
	}
	
	public static double cylinderSurface(double r, double h)
	{
		return (2.0*r*Math.PI*h)+(2.0*Math.PI*r*r);
	}
	
	public static double coneVolume(double r, double h)
	{
		return (1.0/3.0)*Math.PI*r*r*h;
	}
	
	public static double coneSurface(double r, double h)
	{
		return Math.PI*r*(h+r);
	}
}














