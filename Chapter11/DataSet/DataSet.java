//Chapter11 - Example 11.1

public class DataSet 
{
	private double sum;
	private Maximum max;
	private int count;
	
	public DataSet()
	{
	sum = 0;
	//max = 0;
	count = 0;
	}
	
	public void add (Maximum x)
	{
	sum = sum + x.getMax();
	if (count == 0 || max.getMax() < x.getMax())
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
	
	public Maximum getMax()
	{
	return max;
	}
}