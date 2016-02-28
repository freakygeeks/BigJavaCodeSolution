//Chapter 15 - Exercise 15.6

import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DataSetReader
{
	private double[] data;
	
	public double[] readFile(String filename) throws IOException, BadDataException
	{
		FileReader reader = new FileReader(filename);
		try
		{
			Scanner in = new Scanner(reader);
			readData(in);
		}
		
		finally
		{
			reader.close();
		}
		
		return data;
	}
	
	private void readData(Scanner in) throws InputMismatchException
	{
		if (!in.hasNext()) throw new InputMismatchException("Length expected");
				
		int numberOfValues = in.nextInt();
		
		data = new double[numberOfValues];
		
		for (int i = 0; i < numberOfValues; i++)//number of data = 3
		{
			readValue(in, i);
		}
		
		if (in.hasNext()) throw new InputMismatchException("End of file expected");//if the length of data is more than expected
	}
	
	private void readValue(Scanner in, int i) throws NoSuchElementException//BadDataException
	{
		if (!in.hasNext()) throw new NoSuchElementException("Data value expected"); //if the value of data is not enough
		
		data[i] = in.nextDouble();
	}
}
