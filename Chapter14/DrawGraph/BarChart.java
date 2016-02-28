//Chapter 14 - Exercise 14.12

import java.awt.Color;

public class BarChart
{
	private String name;
	private int length;
	private Color aColor;
	
	public BarChart(String n, int l, Color c)
	{
		name = n;
		length = l;
		aColor = c;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Color getColor()
	{
		return aColor;
	}
}