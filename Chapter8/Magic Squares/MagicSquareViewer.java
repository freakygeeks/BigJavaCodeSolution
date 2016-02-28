//Chapter8 - Exercise P8.18 version A

import java.util.Scanner;

public class MagicSquareViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	System.out.print ("Please enter number^2 : ");
	int num = in.nextInt();
	
	double square_num = Math.sqrt(num);
	double square_check = num % square_num;
	
	while (square_check != 0)
		{
		System.out.print ("Your number must be a power of two. Please enter number^2 again : ");
		num = in.nextInt();
		square_num = Math.sqrt(num);
		square_check = num % square_num;			
		}	
			
	MagicSquare calc = new MagicSquare((int) square_num);
	calc.addNum();
	
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