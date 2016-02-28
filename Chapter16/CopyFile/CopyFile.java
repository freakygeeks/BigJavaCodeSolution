//Chapter 16 - Exercise 16.6
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_3
//http://www.java-samples.com/showtutorial.php?tutorialid=330

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile
{
	public static void main (String[] args) throws IOException
	{
		int i;
		FileInputStream fin;
		FileOutputStream fout;
		String text = "";
		
		try 
		{
			//open input file
			try
			{
				fin = new FileInputStream(args[0]);
			}
			
			catch (FileNotFoundException exception)
			{
				System.out.println ("Input File not Found");
				return;
			}
		
		
			//open output file
			try
			{
				fout = new FileOutputStream(args[1]);
			}
		
			catch (FileNotFoundException exception)
			{
				System.out.println ("Error Opening Output File");
				return;
			}
		}
		
		catch (ArrayIndexOutOfBoundsException exception)
		{
			System.out.println ("Usage : CopyFile From To");
			return;
		}
		
		//to copy file
		try
		{
			do
			{
				i = fin.read();
				text = text + (char)i;
				//System.out.println((char)i);
				if (i != -1)
				{
					fout.write(i);
				}
			}
			
			while (i != -1);
		}
	
		catch (IOException exception)
		{
			System.out.println ("File Error");
		}
		
		fin.close();
		fout.close();
		
		System.out.println(text + " : " + text.charAt(23) + " : " + text.charAt(26));
	

	}
}























































