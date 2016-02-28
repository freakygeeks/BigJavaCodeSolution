//Chapter8 - Exercise P8.12

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class Chart extends JComponent 
{
	private ArrayList<Integer> data = new ArrayList<Integer>();//arraylist for data
	private int yLine = 100;//start of y1
	private int width;
	private int height;

	public Chart(int w, int h) 
	{
		width = w;
		height = h;
	}

	public void add(int value) //input for chart length
	{
		data.add(value);//append chart length input to arraylist data
		if (yLine < value) //in case chart length input is higher than value of yLine
		{
			yLine = value;//then yLine value will use chart length value
		}
	}

	public void draw(Graphics2D g2) 
	{
		int xLine = 10;//the start value of x1 and x2 is the same since it is vertical line
		for(Integer numLength: data) //for each input data of numLength in arraylist data
		{
			Line2D.Double chart = new Line2D.Double(xLine, yLine, xLine, yLine - numLength);//(x1, y1, x2, y2)
			g2.draw(chart);//draw the chart
			xLine = xLine + 10;//increment the distance between each chart to value of 10
		}
	}
}

