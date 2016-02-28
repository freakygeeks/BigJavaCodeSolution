//Chapter8 - Exercise P8.15

import java.util.ArrayList;

public class test
{  
	private ArrayList<Double> data;

   public test()
   {
   data = new ArrayList<Double>();
   }
   
   	public void add(double value)
	{
	data.add(value);
	}
   
   public void result()
   {
   
   	double max = 0;
	double sum = 0;
	
	for (Double aValue : data)	
		{
		sum = sum + aValue; 
		
		if (max < aValue)
			{
			max = aValue;
			}
		}
		
	int aWidth = 300;
	int aHeight = 300;
	double pi = 3.142;
   
   	for (int i = 0; i < data.size(); i++)
		{
		double radsum = 0;
   		double percentage = data.get(i)/sum;		
		double degree = percentage*360;
		double radian = (degree/180)*pi;
		
		double aX = Math.cos(radian)*aWidth;
		double aY = Math.sin(radian)*aHeight;
		radsum = radsum + radian;
		
		System.out.println ("Sum Radian : " + radsum);
		System.out.println ("Sum : " + sum);
		System.out.println ("Percentage : " + percentage);
		System.out.println ("Degree : " + degree);
		System.out.println ("Radian : " + radian);
		System.out.println ("aX : " + aX);
		System.out.println ("aY : " + aY);
		System.out.println ();
		}
   }
}