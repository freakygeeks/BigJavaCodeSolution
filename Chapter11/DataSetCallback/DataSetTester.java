//Chapter11 - Example 11.4

import java.awt.Rectangle;

public class DataSetTester
{
	public static void main (String[] args)
	{
	Measurer m = new RectangleMeasurer();
	
	DataSet data = new DataSet(m);
	
	data.add(new Rectangle(5, 10, 20, 30));
	data.add(new Rectangle(10, 20, 30, 40));
	data.add(new Rectangle(20, 30, 5, 10));
	
	System.out.println("Average area = " + data.getAverage());
	
	Rectangle max = (Rectangle) data.getMaximum();
	
	System.out.println ("Maximum area rectangle = " + max);
	}
}