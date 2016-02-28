//Chapter6 - Exercise P6.17

public class UnitConverter
{
	public static final int INCH = 1;
	public static final int FT = 2;
	public static final int MM = 3;
	public static final int CM = 4;
	public static final int M = 5;
	public static final int KM = 6;
	
	//for inch conversion
	private static final double in_ft = 0.08333;
	private static final double in_mm = 25.4;
	private static final double in_cm = 2.54;
	private static final double in_m = 0.0254;
	private static final double in_km = 0.0000254;
	
	//for ft conversion
	private static final double ft_in = 12;
	private static final double ft_mm = 304.8;
	private static final double ft_cm = 30.48;
	private static final double ft_m = 0.3048;
	private static final double ft_km = 0.0003048;
	
	//for mm conversion
	private static final double mm_in = 0.03937;
	private static final double mm_ft = 0.003281;
	private static final double mm_cm = 0.1;
	private static final double mm_m = 0.001;
	private static final double mm_km = 0.000001;
	
	//for cm conversion
	private static final double cm_in = 0.3937;
	private static final double cm_ft = 0.03281;
	private static final double cm_mm = 10;
	private static final double cm_m = 0.01;
	private static final double cm_km = 0.0001;
	
	//for m conversion
	private static final double m_in = 39.37;
	private static final double m_ft = 3.2808;
	private static final double m_mm = 1000;
	private static final double m_cm = 100;
	private static final double m_km = 0.001;
	
	//for km conversion
	private static final double km_in = 39370.0787;
	private static final double km_ft = 3280.8399;
	private static final double km_mm = 1000000;
	private static final double km_cm = 100000;
	private static final double km_m = 1000;
	
	private double num1;
	private double num2;
	private double value;
	
	public UnitConverter (double n1, double n2, double v)
	{
	num1 = n1;
	num2 = n2;
	value = v;
	}
	
	public double getConversion()
	{
	double convert = 0;
	
	if (num1 == INCH)
	{
		if (num2 == FT)
			convert = value*in_ft;
		else if (num2 == MM)
			convert = value*in_mm;
		else if (num2 == CM)
			convert = value*in_cm;
		else if (num2 == M)
			convert = value*in_m;
		else if (num2 == KM)
			convert = value*in_km;
		else
			System.out.println ("Bad input!");
	}
	
	else if (num1 == FT)
	{
		if (num2 == INCH)
			convert = value*ft_in;
		else if (num2 == MM)
			convert = value*ft_mm;
		else if (num2 == CM)
			convert = value*ft_cm;
		else if (num2 == M)
			convert = value*ft_m;
		else if (num2 == KM)
			convert = value*ft_km;
		else
			System.out.println ("Bad input!");	
	}
	
	else if (num1 == MM)
	{
		if (num2 == INCH)
			convert = value*mm_in;
		else if (num2 == FT)
			convert = value*mm_ft;
		else if (num2 == CM)
			convert = value*mm_cm;
		else if (num2 == M)
			convert = value*mm_m;
		else if (num2 ==KM)
			convert = value*mm_km;
		else
			System.out.println ("Bad input!");
	}
	
	else if (num1 == CM)
	{
		if (num2 == INCH)
			convert = value*cm_in;
		else if (num2 == FT)
			convert = value*cm_ft;
		else if (num2 == MM)
			convert = value*cm_mm;
		else if (num2 == M)
			convert = value*cm_m;
		else if (num2 == KM)
			convert = value*cm_km;
		else
			System.out.println ("Bad input!");
	}
	
	else if (num1 == M)
	{
		if (num2 == INCH)
			convert = value*m_in;
		else if (num2 == FT)
			convert = value*m_ft;
		else if (num2 == MM)
			convert = value*m_mm;
		else if (num2 == CM)
			convert = value*m_cm;
		else if (num2 == KM)
			convert = value*m_km;
		else
			System.out.println ("Bad input!");
	}
	
	else if (num1 == KM)
	{
		if (num2 == INCH)
			convert = value*km_in;
		else if (num2 == FT)
			convert = value*km_ft;
		else if (num2 == MM)
			convert = value*km_mm;
		else if (num2 == CM)
			convert = value*km_cm;
		else if (num2 == M)
			convert = value*km_m;
		else
			System.out.println ("Bad input!");
	}
	
	return convert;
	}
}
	
	
	
	
	