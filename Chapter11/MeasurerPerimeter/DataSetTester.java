//Chapter11 - Exercise P11.6

import java.awt.Rectangle;

public class DataSetTester
{
	public static void main (String[] args)
	{
	Measurer m = new RectangleMeasurer(); //type measurer
	
	DataSet data = new DataSet(m); //input type measurer
	
	data.add(new Rectangle(5, 10, 20, 30)); //100
	data.add(new Rectangle(10, 20, 30, 40)); //140
	data.add(new Rectangle(20, 30, 5, 10)); //30
	
	System.out.println("Largest Area = " + data.getMaxArea());
	System.out.println("Smallest Area = " + data.getMinArea());
	System.out.println("Largest Perimeter = " + data.getMaxPerimeter());
	System.out.println("Smallest Perimeter = " + data.getMinPerimeter());
	
	Rectangle max = (Rectangle) data.getMaximum();
	Rectangle min = (Rectangle) data.getMinimum();
	
	System.out.println ("Maximum area rectangle = " + max);
	System.out.println ("Minimum area rectangle = " + min);
	}
}