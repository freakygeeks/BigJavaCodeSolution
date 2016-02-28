//Chapter8 - Exercise P8.15
//http://www.mathsisfun.com/data/pie-charts.html
//http://cs.wellesley.edu/~cs112/assignments/assign1/circle.html
//http://www.hubberspot.com/2012/09/how-to-convert-degrees-into-radians-and.html
//http://www.devmanuals.com/tutorials/java/corejava/degToRad.html
//http://www.mathwarehouse.com/trigonometry/radians/convert-degee-to-radians.php

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;


public class PieChart extends JComponent
{

	private int width;
	private int height;
	private ArrayList<Double> data;
	
	public PieChart(int aWidth, int aHeight)
	{
	width = aWidth;
	height = aHeight;
	data = new ArrayList<Double>();
	}
	
	public void add(double value)
	{
	data.add(value);
	}
	
	public void draw (Graphics2D g2)
	{
	double max = 0;
	double sum = 0;
	
	for (Double aValue : data)	
		{
		sum = sum + aValue; 
		
		if (max < aValue)
			{
			max = aValue;
			}
		}
		
	int xLeft = 0;
	int yLeft = 0;
	
	for (int i = 0; i < data.size(); i++)
		{
		double pointCircleX = width - width/2;
		double pointCircleY = height - height/2;		
		double radius = height/2;
		double pi = 3.142;

		Ellipse2D.Double circle = new Ellipse2D.Double (xLeft, yLeft, width, height);
		g2.draw(circle);		
		
		double percentage = data.get(i)/sum;		
		double degree = percentage*360;
		double radian = (degree/180)*pi;
		double aX = Math.cos(radian)*width;
		double aY = Math.sin(radian)*height;
		
		Line2D.Double line = new Line2D.Double (pointCircleX, pointCircleY, pointCircleX, pointCircleY-radius);
		g2.draw(line);
		
		Line2D.Double lineNext = new Line2D.Double (pointCircleX, pointCircleY, aY, aY);
		g2.draw(lineNext);	
		
		Line2D.Double lineNext2 = new Line2D.Double (pointCircleX, pointCircleY, aY+radius, aY+radius);
		//g2.draw(lineNext2);	

		}	
	}	
}