//Chapter4 - Exercise P4.10
import java.util.Scanner;

public class SquareTester
{
	public static void main (String[] args)
	{
	Square calc = new Square();
	Scanner in = new Scanner(System.in);
	
	System.out.println("Please enter the length side of the square : ");
	double len = in.nextDouble();
	
	calc.insert(len);
	
	System.out.println("The area of a square is : " + calc.getArea());
	System.out.println("The perimeter of a square is : " + calc.getPerimeter());
	System.out.println("The diagonal of square is : " + calc.getDiagonal());
	}
}