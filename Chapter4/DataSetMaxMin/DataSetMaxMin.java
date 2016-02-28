//Chapter4 - Exercise P4.6

public class DataSetMaxMin
{
	private int value;
	private int count;
	private int MAX_VALUE;
	private int MIN_VALUE;
	
	public DataSetMaxMin()
	{
	value = 0;
	count = 0;
	MAX_VALUE = 0;
	MIN_VALUE = 0;
	}
	
	public void addValue (int theValue)
	{
	count++;
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
	
	public int getLargest()
	{
	return this.MAX_VALUE;
	}
	
	public int getSmallest()
	{
	return this.MIN_VALUE;
	}
}
	
	