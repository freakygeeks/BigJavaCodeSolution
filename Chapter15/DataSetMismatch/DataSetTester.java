//Chapter 15 - Exercise 15.6

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataSetTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		DataSetReader reader = new DataSetReader();
		
		boolean done = false;
		while (!done)
		{
			try
			{
				System.out.println("Please enter the file name : ");
				String filename = in.next();
				
				double[] data = reader.readFile(filename);
				double sum = 0;
				
				for (double d : data)
				{
					sum = sum + d;
				}
				
				System.out.println("The sum is " + sum);
				done = true;
			}
			
			catch (FileNotFoundException exception)
			{
				System.out.println ("File not found");
			}
			
			catch (BadDataException exception)
			{
				System.out.println ("Bad data " + exception.getMessage());
			}
			
			catch (IOException exception)
			{
				exception.printStackTrace();
			}
			
			catch (InputMismatchException exception)
			{
				System.out.println ("Input Mismatch. Please try again.");
			}
			
			catch (NoSuchElementException exception)
			{
				System.out.println ("Input not complete. Please try again.");
			}
		}
	}
}
