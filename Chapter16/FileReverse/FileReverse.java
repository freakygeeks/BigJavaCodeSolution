//Chapter 16 - Exercise 16.10
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_7

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReverse
{
	public static String reverse (String line)
	{
		return new StringBuilder(line).reverse().toString();
	}
	
	public static void main (String[] args) throws FileNotFoundException
	{
		String filename;
		
		if (args.length == 1)
		{
			filename = args[0];
		}
		
		else
		{
			System.out.print("File name : ");
			Scanner file = new Scanner (System.in);
			filename = file.next();
			file.close();
		}
		
		Scanner fileRead = new Scanner (new File(filename));
		
		while (fileRead.hasNextLine())
		{
			String line = fileRead.nextLine();
			line = reverse(line);
			System.out.println(line);
		}
		
		fileRead.close();
	}
}




























































