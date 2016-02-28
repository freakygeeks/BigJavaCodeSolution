//Chapter 15 - Exercise 15.7
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_17

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CoinFile
{
	private String name;
	private double value;
	
	public CoinFile()
	{
		name = " ";
		value = 0;
	}
	
	public CoinFile (String aName, double aValue)
	{
		value = aValue;
		name = aName;
	}

	public double getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return name;
	}
	
	/*Reads a coin value and name.
      @param in the Scanner*/
	public void read (Scanner in) throws IOException //based on method read(String input) in Coin.java
	{
		String input = in.nextLine();
		StringTokenizer t = new StringTokenizer(input);

		name = t.nextToken();
		value = Double.parseDouble(t.nextToken());
	}
	
	/*Reads a file with coin values.
      @param filename the file name
      @return an array of coins in the file*/
	public static ArrayList<CoinFile> readFile(String filename) throws IOException //based on method readFile(String filename) in DataSetReader
	{
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		
		ArrayList<CoinFile> CoinList = new ArrayList<CoinFile>();
		CoinFile temp = new CoinFile();
		
		while (in.hasNextLine())
		{
			temp.read(in);
			CoinList.add(new CoinFile(temp.name, temp.value));
		}
		return CoinList;
	}
}






























































