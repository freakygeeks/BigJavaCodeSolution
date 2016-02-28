//Chapter 15 - Example 15.6

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
	
	private void readData(Scanner in) throws BadDataException
	{
		if (!in.hasNextInt()) throw new BadDataException("Length expected");
		
		int numberOfValues = in.nextInt();
		data = new double[numberOfValues];
		
		for (int i = 0; i < numberOfValues; i++)//number of data = 3
		{
			readValue(in, i);
		}
		
		if (in.hasNext()) throw new BadDataException("End of file expected");//if the length of data is more than expected
	}
	
	private void readValue(Scanner in, int i) throws BadDataException
	{
		if (!in.hasNextDouble()) throw new BadDataException("Data value expected");//if the value of data is not enough
		
		data[i] = in.nextDouble();
	}
}




























