//Chapter7 - Exercise P7.15

import java.util.Random;

public class DataSetRandom
{
	private Random gen;
	private double n;
	private double low;
	private double high;
	private double nold;
	private double nnew;
	private double sum;
	private double ave;
	private double max;
	private double min;
	
	DataSetRandom()
	{
	gen = new Random();
	n = 100;
	low = 0;
	high = 1000;
	nold = 0;
	nnew = 0;
	sum = 0;
	ave = 0;
	max = 0;
	min = high+1;
	}
	
	public double getRandomNum()
	{
	for (int i = 1; i <= n; i++)
		{
		nold = low + gen.nextDouble()*(high-low+1);
		nnew = nold;
		sum = sum + nnew;
		max = Math.max(nold, max);
		min = Math.min(nold, min);
		System.out.println ("Random num : " + i + " " + nnew);
		}
		return nnew;
	}
	
	public double getSum()
	{
	return sum;
	}
	
	public double getAverage()
	{
	ave = sum/n;
	return ave;
	}
	
	public double getMax()
	{
	return max;
	}
	
	public double getMin()
	{
	return min;
	}
}