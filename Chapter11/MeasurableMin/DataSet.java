//Chapter11 - Exercise P11.4

public class DataSet 
{
	private double sum;
	private Measureble max;
	private Measureble min;
	private double count;
	private double average;
	
	public DataSet()
	{
	sum = 0;
	count = 0;
	average = 0;
	}
	
	public void add (Measureble x)
	{
	sum = sum + x.getMax();
	if (count == 0 || max.getMax() < x.getMax())
		{
		max = x;		
		}
		
	if (count == 0 || min.getMin() > x.getMin())
		{
		min = x;
		}
		count++;
	}
	
	public double getAverage()
	{
	if (count == 0)
		{
		return 0;
		}
	else 
		{
		double average = sum/count;
		return average;
		}
	}
	
	public Measureble getMaximum()
	{
	return max;
	}
	
	public Measureble getMinimum()
	{
	return min;
	}
}