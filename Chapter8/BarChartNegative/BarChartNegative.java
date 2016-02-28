//Chapter8 - Exercise P8.14

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
 
public class BarChartNegative extends JComponent
{
	private int width;
	private int height;
	private ArrayList<Double> data;//create arraylist type double for barchart value
 
	public BarChartNegative(int aWidth, int aHeight)
	{
	width = aWidth;
	height = aHeight;
	data = new ArrayList<Double>();//define new object for arraylist
	}
 
	public void add(double value)//input for barchart length
	{
	data.add(value);//append barchart length value to arraylist
	}
 
	public void draw(Graphics2D g2)
	{
	int i = 0;
	double max = 0;//start of y1 for positive value
	double min = 0;//start of y1 for negative value
 
	for (Double wrapper : data) //for loop each value input data wrapper to get the most highest number in arraylist data
		{
			if(max < wrapper)
			{
			max = wrapper;
			}
			
			if(min > wrapper)
			{
			min = wrapper;
			}
		}
	int xwidth = width - 1;//300
	int yheight = height - 200;//400-200
	int xleft = 0;
 
	for (i = 0; i < data.size(); i++)
		{
		int xright = xwidth * (i + 1) / data.size();//to get the x1 for the next barchart = 300*(i+1)/7
		int barWidth = xwidth / data.size();//to get the average value of width for each arraylist element = 300/7
		int barHeight = (int) Math.round(yheight * data.get(i) / max);//to get the height of barchart in arraylist = 200*value/maxValue
		int barHeight2 = (int) Math.round(yheight * data.get(i) / min);//to get the height of barchart in arraylist = 200*value/maxValue

		Rectangle bar = new Rectangle(xleft, yheight - barHeight, barWidth, barHeight);//(x, y, width, height) of rectangle
		g2.draw(bar);//draw the chart
		
		Rectangle bar2 = new Rectangle(xleft, yheight, barWidth, barHeight2);//(x, y, width, height) of rectangle
		g2.draw(bar2);//draw the chart
		xleft = xright;//next value of x1 for next barchart
	
		}
	}
}