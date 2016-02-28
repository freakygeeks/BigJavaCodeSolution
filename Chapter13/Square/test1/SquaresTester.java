//Chapter 13 - Exercise 13.3

import java.util.Scanner;

public class SquaresTester
{
	public static void main(String[] args) 
	{
		Scanner newScanX =  new Scanner(System.in);
		Scanner newScanY =  new Scanner(System.in);
		Scanner newScanL =  new Scanner(System.in);

		System.out.println("Enter x:");
		String aX = newScanX.nextLine();
		System.out.println("Enter y:");
		String aY = newScanY.nextLine();
		System.out.println("Enter length:");
		String aL = newScanL.nextLine();

		int x = Integer.parseInt(aX);
		int y = Integer.parseInt(aY);
		int length = Integer.parseInt(aL);

		Squares sq = new Squares(x, y, length); 
		System.out.println(sq.toString()); 
		System.out.println(sq.getArea());
	}
}