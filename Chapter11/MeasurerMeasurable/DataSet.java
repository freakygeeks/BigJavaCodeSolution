//Chapter11 - Exercise P11.7

import java.awt.Rectangle;

public class DataSet 
{
	private double sum;
    private int count;
	private double maxMeasure; 
    private Object max; 
	private Measurer measurer; 
	
    public DataSet(Measurer m) //constructor that implements Measurer interface objects
	{
		sum = 0;
		count = 0;
		maxMeasure = 0; 
        max = null; 
		measurer = m; //input for rectangle object (area)
    }

    public DataSet() //constructor that implements Measurable interface objects
	{
        Measurer defaultMeasurer = new Measurer() //Measurer processing Measurable objects
		{
            public double measure(Object anObject) //Measurer interface
			{
               if (anObject instanceof Measurable) //instanceof : sed to check if an object is an instance of a class, an instance of a subclass, or an instance of a class that implements a particular interface.
			   {
                    Measurable m = (Measurable) anObject; //cast Measurer to Measurable
                    return m.getMeasure(); //return value of bankaccount
               }
               return 0;
            }
        };
    }

	public void add(Rectangle rectangle) //add an object for Rectangle (Measure), carry area value
	{
        if (measurer != null) 
		{
            double measure = measurer.measure(rectangle);
            sum = sum + measure;
            count++;
            if (measure > maxMeasure) 
			{
               maxMeasure = measure;
               max = rectangle;
            }
        }
    }
	
	public void add(Measurable measurable) //add an object for BankAccount (Measurable), carry value
	{
        sum = sum + measurable.getMeasure();
        count++;
        if (measurable.getMeasure() > maxMeasure) 
		{
            maxMeasure = measurable.getMeasure();
            max = measurable;
        }
    }
	
    public double getAverage() //calculate average for both object
	{
        if (count > 0) 
		{
            return sum / count;
        }
        return 0;
    }

    public Object getMaximum() 
	{
        return max;
    }
}
