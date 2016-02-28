//Chapter11 - Exercise P11.2

public class Quiz implements Measure
{
	private double num;
	private String a;
	
	public Quiz(double number)
	{
	num = number;
	}
	
	public String getLetterGrade()
	{
	String a = " ";
	
	if (num > 93.00)
		a = "A";
	else if (num >= 90.00 && num < 92.99)
		a = "A-";
	else if (num >= 87.00 && num < 89.99)
		a = "B+";
	else if (num >= 83.00 && num < 86.99)
		a = "B";
	else if (num >= 80.00 && num < 82.99)
		a = "B-";
	else if (num >= 77.00 && num < 79.99)
		a = "C+";
	else if (num >= 73.00 && num < 76.99)
		a = "C";
	else if (num >= 70.00 && num < 72.99)
		a = "C-";
	else if (num >= 67.00 && num < 69.99)
		a = "D+";
	else if (num >= 60.00 && num < 66.99)
		a = "D";
	else if (num < 59.99)
		a = "F";
	else
	{
		System.out.println ("Bad input!");
	}
	
	return a;
	}
	
	public double getMax()
	{
	return num;
	}
	
}