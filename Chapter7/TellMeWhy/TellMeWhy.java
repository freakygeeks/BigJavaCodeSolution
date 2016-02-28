/*
-----------------------------------------------------------------------------------------------------------------------------------
This program is use to create a random number between 10 and 100.
-----------------------------------------------------------------------------------------------------------------------------------
Copyright (C) 2014 by NieSe.

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
import java.util.Random;

public class TellMeWhy
{
	private Random gen;
	private int num1;
	private int num2;
	private double no1;
	private double no2;
	private int low;
	private int high;
	
	TellMeWhy()
	{
	gen = new Random();
	num1 = 0;
	num2 = 0;
	no1 = 0;
	no2 = 0;
	low = 10;
	high = 100;
	}
	
	public int getNum1()
	{
	int range = high - low + 1; 
	num1 = low + gen.nextInt(range);
	System.out.println ("getNum1() : " + num1);
	return num1;
	}
	
	public int getNum2()
	{
	num2 = low + gen.nextInt()*(high - low + 1);
	System.out.println ("getNum2() : " + num2);
	return num2;	
	}
	
	public double getNo1()
	{
	int range = high - low + 1; 
	no1 = low + gen.nextInt(range);
	System.out.println ("getNo1() : " + no1);
	return no1;
	}
	
	public double getNo2()
	{
	no2 = low + gen.nextInt()*(high - low + 1);
	System.out.println ("getNo2() : " + no2);
	return no2;
	}

	public static void main (String[] args)
	{
	TellMeWhy calc = new TellMeWhy();

	System.out.println("\n" + "This program is use to create a random number between 10 and 100");
	System.out.println("Generating random int..");
	calc.getNum1();
	calc.getNum2();
	System.out.println("Generating random double..");
	calc.getNo1();
	calc.getNo2();
	System.out.println("Now, correct the code!");
	}
}