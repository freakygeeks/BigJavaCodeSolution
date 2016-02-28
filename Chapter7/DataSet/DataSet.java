//Chapter7 - Example 7.4

public class DataSet
{
	private double sum;
	private double max;
	private int count;
	
	public DataSet()
	{
	sum = 0;
	max = 0;
	count = 0;
	}
	
	public void add (double x)
	{
	sum = sum + x;
	if (count == 0 || max < x)
		max = x;
		count++;
	}
	
	public double getAverage()
	{
	if (count == 0)
		return 0;
	else 
		return sum/count;
	}
	
	public double getMax()
	{
	return max;
	}
}