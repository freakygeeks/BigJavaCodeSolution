//Chapter11 - Exercise P11.1

public class DataSet 
{
	private double sum;
	private Measure max;
	private double count;
	private double average;
	
	public DataSet()
	{
	sum = 0;
	count = 0;
	average = 0;
	}
	
	public void add (Measure x)
	{
	sum = sum + x.getMax();
	if (count == 0 || max.getMax() < x.getMax())
		max = x;
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
	
	public Measure getMax()
	{
	return max;
	}
}