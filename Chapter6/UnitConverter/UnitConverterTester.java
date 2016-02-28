//Chapter6 - Exercise P6.17

import java.util.Scanner;

public class UnitConverterTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Convert from - in/ft/mm/cm/m/km : ");
	String input1 = in.nextLine();
	
	int unit1 = 0;
	{
	if (input1.equalsIgnoreCase("in"))
		unit1 = UnitConverter.INCH;
	else if (input1.equalsIgnoreCase("ft"))
		unit1 = UnitConverter.FT;
	else if (input1.equalsIgnoreCase("mm"))
		unit1 = UnitConverter.MM;
	else if (input1.equalsIgnoreCase("cm"))
		unit1 = UnitConverter.CM;
	else if (input1.equalsIgnoreCase("m"))
		unit1 = UnitConverter.M;
	else if (input1.equalsIgnoreCase("km"))
		unit1 = UnitConverter.KM;
	else
	{
		System.out.println ("Bad input!");	
		return;
	}
	}
	
	System.out.print ("Convert to - in/ft/mm/cm/m/km : ");
	String input2 = in.nextLine();
	
	int unit2 = 0;
	{
	if (input2.equalsIgnoreCase("in"))
		unit2 = UnitConverter.INCH;
	else if (input2.equalsIgnoreCase("ft"))
		unit2 = UnitConverter.FT;
	else if (input2.equalsIgnoreCase("mm"))
		unit2 = UnitConverter.MM;
	else if (input2.equalsIgnoreCase("cm"))
		unit2 = UnitConverter.CM;
	else if (input2.equalsIgnoreCase("m"))
		unit2 = UnitConverter.M;
	else if (input2.equalsIgnoreCase("km"))
		unit2 = UnitConverter.KM;
	else
	{
		System.out.println ("Bad input!");
		return;
	}
	}
	
	System.out.print ("Enter value to convert : ");
	double value = in.nextDouble();
	
	UnitConverter calc = new UnitConverter (unit1, unit2, value);
	System.out.println ("The unit conversion from " + input1 + " to " + input2 + " is " + calc.getConversion() + input2);
	}
}