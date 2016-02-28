//Chapter 18 - Exercise P18.8
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_8
//https://www.daniweb.com/software-development/java/threads/178927/area-of-a-polygon
//https://answers.yahoo.com/question/index?qid=20130304122441AAH2iSL
//http://bytes.com/topic/java/answers/880908-arraylist-program-help
//http://en.wikipedia.org/wiki/Shoelace_formula

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Polygon
{
	private ArrayList<Point2D.Double> corners;
	private double area;
	private double adding;
	private double minus;
	private double exAdding;
	private double exMinus;
	
	public Polygon()
	{
		corners = new ArrayList<Point2D.Double>();
		area = 0;
		adding = 0;
		minus = 0;
		exAdding = 0;
		exMinus = 0;
	}
	
	//add point to the array
	public void add (Point2D.Double p)
	{
		corners.add(p);
	}
	
	//computes area of polygon
	public double getArea()
	{
		//return computeArea(corners, corners.size());
		return recursionMethod(corners, corners.size(), 0);
	}
	
	//recursion method
	public double recursionMethod(ArrayList<Point2D.Double> c, int size, int count)
	{
      if (count<size-1)
	  {
			double xA = c.get(count).getX();
			double yA = c.get(count).getY();
			double xB = c.get(count+1).getX();
			double yB = c.get(count+1).getY();

			exAdding = c.get(size-1).getX()*c.get(size-size).getY();
			adding = adding + xA*yB; 

			exMinus = c.get(size-1).getY()*c.get(size-size).getX();
			minus = minus + yA*xB;
			recursionMethod(c, size, count+1);
		}
	   
	   	else
		{
			return 0;
		}
	   
	   	area = Math.abs((adding+exAdding) - (minus+exMinus));
			
		return area/2;
    }
	
	//iteration method
	public double computeArea(ArrayList<Point2D.Double> c, int size)
	{
		if (size < 0)
		{
			return 0;
		}
		
		else
		{
			for (int i = 0; i < size-1; i++)
			{
				double xA = c.get(i).getX();
				double yA = c.get(i).getY();
				double xB = c.get(i+1).getX();
				double yB = c.get(i+1).getY();
				
				exAdding = c.get(size-1).getX()*c.get(size-size).getY();
				adding = adding + xA*yB; 
				
				exMinus = c.get(size-1).getY()*c.get(size-size).getX();
				minus = minus + yA*xB;
				
				//System.out.println("test adding : " + adding);
			}
			//System.out.println("extra adding : " + exAdding);
			area = Math.abs((adding+exAdding) - (minus+exMinus));
			
			return area/2;
		}
	}
}