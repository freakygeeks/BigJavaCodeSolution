//Chapter 18 - Exercise P18.8

import java.awt.geom.Point2D;

public class PolygonTester
{
	public static void main (String[] args)
	{
		//create square
		Polygon p = new Polygon();
		p.add(new Point2D.Double(10, 20));
		p.add(new Point2D.Double(20, 20));
		p.add(new Point2D.Double(20, 10));
		p.add(new Point2D.Double(10, 10));
		
		System.out.println("Area : " + p.getArea());
		System.out.println("Expected : 100");
		
		
		//create square
		Polygon p1 = new Polygon();
		p1.add(new Point2D.Double(3, 4));
		p1.add(new Point2D.Double(5, 11));
		p1.add(new Point2D.Double(12, 8));
		p1.add(new Point2D.Double(9, 5));
		p1.add(new Point2D.Double(5, 6));
		
		System.out.println("Area : " + p1.getArea());
		System.out.println("Expected : 30");
		
		//regular hexagon with radius 1
		p = new Polygon();
		
		for (int i = 0; i < 6; i++)
		{
			p.add(new Point2D.Double(Math.sin(i*Math.PI/3), Math.cos(i*Math.PI/3)));
		}
		
		System.out.println("Area : " + p.getArea());
		System.out.println("Expected : " + 3*Math.sqrt(3)/2);
	}
}