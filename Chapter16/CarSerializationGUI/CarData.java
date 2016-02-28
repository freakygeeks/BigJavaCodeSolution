//Chapter 16 - Project 16.1

import java.util.ArrayList;
import java.io.Serializable;

public class CarData implements Serializable // contains an array list of cars
{
	private ArrayList data;
	
	public CarData()
	{
		data = new ArrayList();
	}
	
	public void add (int x, int y)
	{
		Car c = new Car (x, y);
		data.add(c);
	}
	
	public int size()
	{
		return data.size();
	}
	
	public void clear()
	{
		data.clear();
	}
	
	public Car get (int n)
	{
		return (Car)data.get(n);
	}
}























































