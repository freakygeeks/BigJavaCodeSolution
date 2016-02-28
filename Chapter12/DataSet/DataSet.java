//Chapter 12 - Exercise 12.10

public class DataSet
{
	private double value;
	private double count;
	private double sum;
	private double average;
	private double MAX_VALUE;
	private double MIN_VALUE;
	
	public DataSet()
	{
	sum = 0;
	average = 0;
	value = 0;
	count = 0;
	MAX_VALUE = 0;
	MIN_VALUE = MAX_VALUE + 1000;
	}
	
	public void addValue (double theValue)
	{
	count++;
	this.value = this.value + theValue;
	this.MAX_VALUE = Math.max(this.MAX_VALUE, theValue);
	this.MIN_VALUE = Math.min(this.MIN_VALUE, theValue);
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
	
	public double getLargest()
	{
	return this.MAX_VALUE;
	}
	
	public double getSmallest()
	{
	return this.MIN_VALUE;
	}
}
	