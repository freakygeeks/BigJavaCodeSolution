//Chapter 6 - Exercise P6.9

import java.util.Scanner;

public class LetterGradeViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Enter a numeric grade");
	double input = in.nextDouble();
	
	LetterGrade calc = new LetterGrade(input);
	System.out.println("The letter grade value is : " + calc.getLetterGrade());
	}
}