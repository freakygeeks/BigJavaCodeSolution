//Chapter8 - Exercise P8.18 version B

import java.util.Scanner;

public class MagicSquaresViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	System.out.print("Please enter number : ");
	int num = in.nextInt(); //input number
	
	double square_num = Math.sqrt(num); //input number sqrt of two
	double square_check = num % square_num; //get the reminder of input number divide by number sqrt of two
	
		while (square_check != 0) // if reminder not 0
			{
			System.out.print("Your number must be a power of two. Please enter number again : ");
			num = in.nextInt(); //get next input
			square_num = Math.sqrt(num);
			square_check = num % square_num;
			}
		
	//System.out.println ("square root number : " + square_num);
	//System.out.println ("square root number  check: " + square_check);
	
	MagicSquares calc = new MagicSquares((int) square_num);
	calc.addMagic();
	}
}
