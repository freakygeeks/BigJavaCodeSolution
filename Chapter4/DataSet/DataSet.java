//Chapter4 - Exercise P4.5 & P4.6
public class DataSet
{
	private double value;
	private double sum;
	private double average;
	private double count;
	private double MIN_VALUE;
	private double MAX_VALUE;
	
	public DataSet()
	{
	value = 0;
	sum = 0;
	average = 0;
	count = 0;
	}
	
	public void addValue (double theValue)
	{
	count++;
	this.value = this.value + theValue;
	}
	
	public double getSum()
	{
	this.sum = this.value;
	return this.sum;
	}
	
	public double getAverage()
	{
	this.average = this.sum/this.count;
	return this.average;
	}
}
	
	
	