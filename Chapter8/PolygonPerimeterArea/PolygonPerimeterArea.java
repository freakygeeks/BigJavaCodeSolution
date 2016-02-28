//Chapter8 - Exercise P8.9

import java.awt.Graphics2D;//use method draw (Graphics2D g2)
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PolygonPerimeterArea extends JComponent
{
	private ArrayList<Point2D.Double> listPolygon1; 
	private ArrayList<Point2D.Double> listPolygon2;
	private double p;
	private double a;
	
	public PolygonPerimeterArea()
	{
	listPolygon1 = new ArrayList<Point2D.Double>();
	listPolygon2 = new ArrayList<Point2D.Double>();
	p = 0;
	a = 0;
	}
	
	public void add (Point2D.Double aPoint)
	{
	listPolygon1.add(aPoint);
	}
	
	public void adds (Point2D.Double aPoint)
	{
	listPolygon2.add(aPoint);
	}
	
	public double perimeter()
	{
	return p;
	}
	
	public double area()
	{
	return a;
	}
	
	public void draw (Graphics2D g2)
	{
	
	for (int i = 0; i < listPolygon1.size(); i ++)
		{
		Point2D.Double pointPolygon;
		pointPolygon = listPolygon1.get(i);
		
		Point2D.Double pointPolygon0;
		pointPolygon0 = listPolygon1.get(0);
		
		Point2D.Double pointPolygon1;
		pointPolygon1 = listPolygon1.get(1);
		
		Point2D.Double pointPolygon2;
		pointPolygon2 = listPolygon1.get(2);
		
		Point2D.Double pointPolygon3;
		pointPolygon3 = listPolygon1.get(3);
		
		//to calculate the perimeter of square
		double b = pointPolygon3.x - pointPolygon0.x;
		p = b*(listPolygon1.size()-1);
		
		//to calculate the area of square
		double c = 0.5*(Math.abs(pointPolygon0.x*pointPolygon1.y) + Math.abs(pointPolygon1.x*pointPolygon2.y) + Math.abs(pointPolygon2.x*pointPolygon3.y) + Math.abs(pointPolygon3.x*pointPolygon0.y) - 
						Math.abs(pointPolygon0.y*pointPolygon1.x) - Math.abs(pointPolygon1.y*pointPolygon2.x) - Math.abs(pointPolygon2.y*pointPolygon3.x) - Math.abs(pointPolygon3.y*pointPolygon0.x));
		a = Math.abs(c);
		
		if(i == 0)
			{
			Line2D.Double line1 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon1.x, pointPolygon1.y);
			g2.setColor(Color.BLUE);
			g2.draw(line1);
			
			Line2D.Double line2 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon3.x, pointPolygon3.y);
			g2.setColor(Color.BLUE);
			g2.draw(line2);
			}
		else if ( i == 2)
			{
			Line2D.Double line1 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon1.x, pointPolygon1.y);
			g2.setColor(Color.BLUE);
			g2.draw(line1);
			
			Line2D.Double line2 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon3.x, pointPolygon3.y);
			g2.setColor(Color.BLUE);
			g2.draw(line2);			
			}
		else
			{
			g2.setColor(Color.RED);
			g2.drawString("Square Perimeter : " + p, 100, 30);		

			g2.setColor(Color.RED);
			g2.drawString("Square Area : " + a, 100, 50);				
			}
		/*	
		Rectangle2D.Double polygon2 = new Rectangle2D.Double (pointPolygon.x, pointPolygon.y, 10, 10);
		g2.setColor(Color.GREEN);
		g2.draw(polygon2);
		*/
		}
	
	for (int i = 0; i < listPolygon2.size(); i ++)
		{
		Point2D.Double pointPolygon;
		pointPolygon = listPolygon2.get(i);
				
		Point2D.Double pointPolygon0;
		pointPolygon0 = listPolygon2.get(0);
		
		Point2D.Double pointPolygon1;
		pointPolygon1 = listPolygon2.get(1);
		
		Point2D.Double pointPolygon3;
		pointPolygon3 = listPolygon2.get(3);
		
		Point2D.Double pointPolygon2;
		pointPolygon2 = listPolygon2.get(2);
		
		Point2D.Double pointPolygon4;
		pointPolygon4 = listPolygon2.get(4);
		
		//to calculate the perimeter of pentagon
		double b = pointPolygon0.x - pointPolygon1.x;
		p = b*(listPolygon2.size()-1);
		
		//to calculate the area of square
		double c = 0.5*(Math.abs(pointPolygon0.x*pointPolygon1.y) + Math.abs(pointPolygon1.x*pointPolygon2.y) + Math.abs(pointPolygon2.x*pointPolygon3.y) + Math.abs(pointPolygon3.x*pointPolygon4.y) + Math.abs(pointPolygon4.x*pointPolygon0.y) - 
						Math.abs(pointPolygon0.y*pointPolygon1.x) - Math.abs(pointPolygon1.y*pointPolygon2.x) - Math.abs(pointPolygon2.y*pointPolygon3.x) - Math.abs(pointPolygon3.y*pointPolygon4.x) - Math.abs(pointPolygon4.y*pointPolygon0.x));
		a = Math.abs(c);
		
		if(i == 1)
			{
			Line2D.Double line1 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon0.x, pointPolygon0.y);
			g2.setColor(Color.MAGENTA);
			g2.draw(line1);
			
			Line2D.Double line2 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon2.x, pointPolygon2.y);
			g2.setColor(Color.MAGENTA);
			g2.draw(line2);
			}
		else if(i == 3)
			{
			Line2D.Double line1 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon2.x, pointPolygon2.y);
			g2.setColor(Color.MAGENTA);
			g2.draw(line1);
			
			Line2D.Double line2 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon4.x, pointPolygon4.y);
			g2.setColor(Color.MAGENTA);
			g2.draw(line2);
			}
			
		else if(i == 4)
			{
			Line2D.Double line1 = new Line2D.Double (pointPolygon.x, pointPolygon.y, pointPolygon0.x, pointPolygon0.y);
			g2.setColor(Color.MAGENTA);
			g2.draw(line1);
			}
		else
			{
			g2.setColor(Color.RED);
			g2.drawString("Pentagon Perimeter : " + p, 180, 100);		

			g2.setColor(Color.RED);
			g2.drawString("Pentagon Area : " + a, 180, 120);				
			}
		/*
		Rectangle2D.Double polygon2 = new Rectangle2D.Double (pointPolygon.x, pointPolygon.y, 10, 10);
		g2.setColor(Color.BLACK);
		g2.draw(polygon2);
		*/
		}
	}	
}