//Chapter 6 - Exercise P6.8

public class NumericGrade
{
	private String gra;
	
	public NumericGrade(String grade)
	{
	gra = grade;
	}
	
	public String getNumericGrade()
	{
	String g = " ";
	
	if (gra.equalsIgnoreCase("A+"))
		g = "4.0";
	else if (gra.equalsIgnoreCase("A"))
		g = "4.0";
	else if (gra.equalsIgnoreCase("A-"))
		g = "3.7";
	else if (gra.equalsIgnoreCase("B+"))
		g = "3.3";
	else if (gra.equalsIgnoreCase("B"))
		g = "3.0";
	else if (gra.equalsIgnoreCase("B-"))
		g = "2.7";
	else if (gra.equalsIgnoreCase("C+"))
		g = "2.3";
	else if (gra.equalsIgnoreCase("C"))
		g = "2.0";
	else if (gra.equalsIgnoreCase("C-"))
		g = "1.7";
	else if (gra.equalsIgnoreCase("D+"))
		g = "1.3";
	else if (gra.equalsIgnoreCase("D"))
		g = "1.0";
	else if (gra.equalsIgnoreCase("D-"))
		g = "0.7";
	//else if (gra.equalsIgnoreCase("F"))
		//g = "0.0";
	else
	{
		g = "0.0";
		//System.out.println ("Bad input!");
	}
	
	return g;
	}
}