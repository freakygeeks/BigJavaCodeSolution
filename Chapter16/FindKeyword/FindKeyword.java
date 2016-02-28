//Chapter 16 - Exercise 16.8
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindKeyword
{
	public static String findWord;
		
	public static void main (String[] args) throws FileNotFoundException
	{
		ArrayList<String> file = new ArrayList<String>();
		
		if (args.length >= 2)
		{
			findWord = args[0];
			
			for (int i = 1; i < args.length; i++)
			{
				file.add(args[i]);
			}
			
			System.out.println(file.toString()); //file name
		}
		
		for (int i = 0; i < file.size(); i++)
		{
			find(file.get(i));
		}
	}
	
	public static void find (String filename) throws FileNotFoundException
	{
		int num = 0;
		String output = "";
		String result = "";
		Scanner fileRead = new Scanner(new File(filename));
		
		while (fileRead.hasNextLine())
		{
			String[] line = fileRead.nextLine().split("\\s+");
			
			if (Arrays.asList(line).contains(findWord))
			{
				if(output.length() < 1 || output.length() > 0)
				{
					/*for (String item : line)
					{
						output = String.format("%s : ", filename);
						result = result + item + " ";
					}*/
					num++;
					for (int i = 0; i < line.length; i++)
					{
						output = String.format("%s - ", filename);
						result = result + line[i] + " ";
						
					}
				}
				
				else
				{
					output = output + " " + line;
				}
			}			
		}
		
		fileRead.close();
		System.out.println(output + "Total line " + num + " : " + result);
	}
}










































