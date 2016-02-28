//Chapter8 - Exercise P8.19

import java.util.Scanner;

public class MagicSquaresOddViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	System.out.print("Please enter number : ");
	int num = in.nextInt(); //input number
	
	double odd_num = num % 2; //input number divide by two and get the remainder
	
		while (odd_num == 0) // if reminder not 0
			{
			System.out.print("Your number must be an odd number. Please enter number again : ");
			num = in.nextInt(); //get next input
			odd_num = num% 2;
			}

	MagicSquaresOdd calc = new MagicSquaresOdd((int) num);
	calc.addMagic();
	
	
	if (calc.isMagic() == true) 
		{
        System.out.println("The array is a magic square\n");
		} 
	else 
		{
        System.out.println("The array is not a magic square\n");
		}
	}
}
