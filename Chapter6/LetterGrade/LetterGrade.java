//Chapter 6 - Exercise P6.9

public class LetterGrade
{
	private double num;
	
	public LetterGrade(double number)
	{
	num = number;
	}
	
	public String getLetterGrade()
	{
	String a = " ";
	
	if (num == 4.0)
		a = "A";
	else if (num >= 3.7 && num < 4.0)
		a = "A-";
	else if (num >= 3.3 && num < 3.7)
		a = "B+";
	else if (num >= 3.0 && num < 3.3)
		a = "B";
	else if (num >= 2.7 && num < 3.0)
		a = "B-";
	else if (num >= 2.3 && num < 2.7)
		a = "C+";
	else if (num >= 2.0 && num < 2.3)
		a = "C";
	else if (num >= 1.7 && num < 2.0)
		a = "C-";
	else if (num >= 1.3 && num < 1.7)
		a = "D+";
	else if (num >= 1.0 && num < 1.3)
		a = "D";
	else if (num >= 0.7 && num < 1.0)
		a = "D-";
	else if (num < 0.7)
		a = "F";
	else
	{
		System.out.println ("Bad input!");
	}
	
	return a;
	}
}