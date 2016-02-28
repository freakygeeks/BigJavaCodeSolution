//Chapter11 - Exercise P11.6

public class DataSet
{
	private double maxPerimeter;
	private double minPerimeter;
	private double maxArea;
	private double minArea;
	private Object maximum;
	private Object minimum;
	private double count;
	private Measurer measurer;
	
	public DataSet(Measurer aMeasurer) //pass the RectangleMeasurer method to DataSet
	{
	maxPerimeter = 0;
	minPerimeter = 0;
	maxArea = 0;
	minArea = 0;
	count = 0;
	maximum = null;
	minimum = null;
	measurer = aMeasurer;
	}
	
	public void add (Object x)
	{	
	if (count == 0 || measurer.measureArea(maximum) < measurer.measureArea(x))	
		{
		maximum = x;
		}
		
	if (count == 0 || measurer.measureArea(minimum) > measurer.measureArea(x))	
		{
		minimum = x;
		}

	if (count == 0 || measurer.measurePerimeter(maximum) < measurer.measurePerimeter(x))	
		{
		maximum = x;
		}
		
	if (count == 0 || measurer.measurePerimeter(minimum) > measurer.measurePerimeter(x))	
		{
		minimum = x;
		}
	
	count++;
	
	maxArea = measurer.measureArea(maximum);
	minArea = measurer.measureArea(minimum);
	
	maxPerimeter = measurer.measurePerimeter(maximum); 
	minPerimeter = measurer.measurePerimeter(minimum); 	
	}
	
	public double getMaxArea()
	{
	if (count == 0)
		{
		return 0;
		}
	else
		{
		return maxArea;
		}
	}
	
	public double getMinArea()
	{
	if (count == 0)
		{
		return 0;
		}
	else
		{
		return minArea;
		}
	}
	
	public double getMaxPerimeter()
	{
	if (count == 0)
		{
		return 0;
		}
	else
		{
		return maxPerimeter;
		}
	}
	
	public double getMinPerimeter()
	{
	if (count == 0)
		{
		return 0;
		}
	else
		{
		return minPerimeter;
		}
	}
	
	public Object getMaximum()
	{
	return maximum;
	}
	
	public Object getMinimum()
	{
	return minimum;
	}
	
}
