//Chapter4 - Exercise P4.7
public class Converter
{
	public static final double METER_TO_MILE = 0.000621371;
	public static final double METER_TO_FEET = 3.28084;
	public static final double METER_TO_INCH = 39.370;
	private double meter;
	
	public Converter()
	{
	meter = 0;
	}
	
	public void insert (double value)
	{
	this.meter = this.meter + value;
	}
	
	public double getMile ()
	{
	double mile = (double)(meter*METER_TO_MILE);
	return mile;
	}
	
	public double getFeet()
	{
	double feet = (double)(meter*METER_TO_FEET);
	return feet;
	}
	
	public double getInch()
	{
	double inch = (double)(meter*METER_TO_INCH);
	return inch;
	}
}
	