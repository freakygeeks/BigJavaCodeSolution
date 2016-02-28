//Chapter8 - Exercise P8.8
//http://horstmann.com/javabrat/ExP8_8.html
//https://www.daniweb.com/software-development/java/threads/416695/draw-polygon-help

import java.awt.Graphics2D;//use method draw (Graphics2D g2)
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Polygon extends JComponent
{
	private ArrayList<Point2D.Double> listPolygon1; 
	private ArrayList<Point2D.Double> listPolygon2;
	
	public Polygon()
	{
	listPolygon1 = new ArrayList<Point2D.Double>();
	listPolygon2 = new ArrayList<Point2D.Double>();
	}
	
	public void add (Point2D.Double aPoint)
	{
	listPolygon1.add(aPoint);
	}
	
	public void adds (Point2D.Double aPoint)
	{
	listPolygon2.add(aPoint);
	}
	
	public void draw (Graphics2D g2)
	{
	for (int i = 0; i < listPolygon1.size(); i ++)
		{
		Point2D.Double pointPolygon;
		pointPolygon = listPolygon1.get(i);
		
		Point2D.Double pointPolygon1;
		pointPolygon1 = listPolygon1.get(1);
		
		Point2D.Double pointPolygon3;
		pointPolygon3 = listPolygon1.get(3);
		
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
			g2.drawString("square", 100, 80);			
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
		
		Point2D.Double pointPolygon2;
		pointPolygon2 = listPolygon2.get(2);
		
		Point2D.Double pointPolygon4;
		pointPolygon4 = listPolygon2.get(4);
		
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
			g2.drawString("pentagon", 180, 140);			
			}
		/*
		Rectangle2D.Double polygon2 = new Rectangle2D.Double (pointPolygon.x, pointPolygon.y, 10, 10);
		g2.setColor(Color.BLACK);
		g2.draw(polygon2);
		*/
		}
	}	
}