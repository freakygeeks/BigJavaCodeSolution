//Chapter 16 - Example 16.1

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumberer
{
	public static void main (String[] args)
	{
		/*for (String a : args)
		{
			if (a.startWith("-"))
			{
				if(a.equals("-c")) userCommentDelimiters = true;
			}
			
			else if (inputFile == null) inputFile = a;
			else if (outputFile == null) outputFile = a;
		}*/
		
		Scanner console = new Scanner (System.in);
		System.out.print ("Input file : ");
		String inputFile = console.next();
		System.out.print("Output file : ");
		String outputFile = console.next();
		
		try 
		{
			FileReader reader = new FileReader(inputFile);
			Scanner in = new Scanner (reader);
			PrintWriter out = new PrintWriter(outputFile);
			int lineNumber = 1; //number of line input
			
			while (in.hasNextLine())
			{
				String line = in.nextLine(); //the input data per line
				System.out.println(line + " : " + line.charAt(0));
				out.println ("/*" + lineNumber + "*/" + line);
				lineNumber++;
			}
			
			out.close();
		}
		
		catch (IOException exception)
		{
			System.out.println ("Error processing file : " + exception);
		}
	}
}




















