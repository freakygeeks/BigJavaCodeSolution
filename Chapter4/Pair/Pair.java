//Chapter4 - Exercise P4.4
public class Pair
{
	private double FirstValue;
	private double SecondValue;
	private double sum;
	private double average;
	private double diff;
	
	public Pair ()
	{
	FirstValue = 0;
	SecondValue = 0;
	sum = 0;
	average = 0;
	diff = 0;
	}
	
	public void getSum (double first, double second)
	{
	this.FirstValue = this.FirstValue + first;
	this.SecondValue = this.SecondValue + second;
	}
	
	public double resultSum ()
	{
	this.sum = this.FirstValue + this.SecondValue;
	return this.sum;
	}
	
	public double resultAverage()
	{
	this.average = (this.FirstValue + this.SecondValue)/2;
	return this.average;
	}
	
}