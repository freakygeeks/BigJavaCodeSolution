//Chapter 6 - Exercise P6.8

import java.util.Scanner;

public class NumericGradeViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter a letter grade : ");
	String letter = in.nextLine();
	
	NumericGrade calc = new NumericGrade(letter);
	System.out.println ("The numeric value is : " + calc.getNumericGrade());
	}
}