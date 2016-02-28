//Chapter 14 - Project 14.1

import java.awt.Color;

public class PieChart
{
	private String name;
	private int length;
	private Color aColor;
	
	public PieChart(String n, int l, Color c)
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