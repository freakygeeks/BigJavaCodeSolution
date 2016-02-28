//Chapter4 - Exercise 4.12
import java.util.Scanner;

public class DigitExtractorTester
{
	public static void main (String[] args)
	{
	DigitExtractor calc = new DigitExtractor();
	Scanner in = new Scanner(System.in);
	
	System.out.println("Please enter your 5 digit number : ");
	int digit = in.nextInt();
	
	calc.insertDigit(digit);
	System.out.println("Your first digit is : " + calc.nextDigit());
	System.out.println("Your second digit is : " + calc.nextDigit());
	System.out.println("Your third digit is : " + calc.nextDigit());
	System.out.println("Your fourth digit is : " + calc.nextDigit());
	System.out.println("Your fifth digit is : " + calc.nextDigit());
	}
}