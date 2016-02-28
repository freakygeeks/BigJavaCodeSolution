//Chapter11 - Exercise P11.8

import java.awt.Rectangle;

public class DataSet 
{
	private double sum;
    private int count;
	private double maxMeasure; 
    private Object max; 
	private Measurer measurer; 
	private Filter filterBoolean;
	
    public DataSet(Measurer mRect) //constructor that implements Measurer interface objects
	{
		sum = 0;
		count = 0;
		measurer = mRect; //input for rectangle object (area)
    }

    public DataSet() //default constructor that implements Measurable interface objects
	{
       /* Measurer defaultMeasurer = new Measurer() //Measurer processing Measurable objects
		{
            public double measure(Object anObject) //Measurer interface
			{
               if (anObject instanceof Measurable) //instanceof : sed to check if an object is an instance of a class, an instance of a subclass, or an instance of a class that implements a particular interface.
			   {
                    Measurable aMeasurer = (Measurable) anObject; //cast Measurer to Measurable
                    return aMeasurer.getMeasure(); //return value of bankaccount
               }
               return 0;
            }
        };
		
		Filter defaultFilter = new Filter()
		{
			public boolean accept (Object x)
			{
				if (x instanceof Measurable)
				{
				Measurable aFilter = (Measurable) x;
				return aFilter.getAccept();
				}
				return false;
			}
		};*/
    }
	
	public DataSet(Measurer mBank, Filter f) //constructor that implements Measurer interface objects
	{
		sum = 0;
		count = 0;
		measurer = mBank; 
		filterBoolean = f;
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
	
	public void add(Measurable measurable) //add an object for BankAccount (Measurable), carry  account value
	{

        if (measurable.getMeasure() > maxMeasure) 
		{
            maxMeasure = measurable.getMeasure();
            max = measurable;
        }
				
		if (measurable.getMeasure() > 1000)
		{
			sum = sum + measurable.getMeasure();
			count++;
        }
    }
	
	public void addTest (BankAccount bank) //add an object for Rectangle (Measure), carry area value
	{
        if (measurer != null) 
		{
            double measure = measurer.measure(bank);
            if (measure > maxMeasure) 
			{
               maxMeasure = measure;
               max = bank;
            }
			
			if (filterBoolean.accept(bank))
			{
			sum = sum + measure;
            count++;
			}
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
