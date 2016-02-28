//Chapter7 - Exercise P7.6

public class MeanDeviation
{
	private double sum;
	private double mean;
	private double deviation;
	private int count;
	private double cuba;
	
	MeanDeviation()
	{
	sum = 0;
	mean = 0;
	deviation = 0;
	count = 0;
	cuba = 0;
	}
	
	public void getSum(double num)
	{
	sum = sum + num;
	count++;
	}
	
	public double getMean()
	{
	mean = sum/count;
	return mean;
	}
	
	public double getDeviation()
	{
	deviation = Math.sqrt(((Math.pow((sum-mean),2)))/(count-1));
	cuba = (Math.pow((8-2.6667),2))/(count-1);
	return deviation;
	}
	
	public int getCount()
	{
	return count;
	}
}