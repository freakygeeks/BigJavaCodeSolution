//Chapter 16 - Exercise 16.5
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch19/c19_exp_19_4
//http://en.wikipedia.org/wiki/Playfair_cipher

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.Reader;
import java.io.Writer;

public class PlayfairCipher
{
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private String key;
	private char[][] keys;
	
	public PlayfairCipher(String aKey)
	{
		key = aKey;
		keys = makeEncryptionKey(key);
	}
	
	//open both input and output file
	public void processFile(File inFile, File outFile) throws IOException
	{
		FileReader in = null;
		FileWriter out = null;
		
		try
		{
			in = new FileReader(inFile);
			out = new FileWriter(outFile);
			process(in, out);
		}
		
		finally
		{
			if (in != null)
			{
				in.close();
			}
			
			if (out != null)
			{
				out.close();
			}
		}
	}
	
	public void process (Reader in, Writer out) throws IOException
	{
		while (true)
		{
			//read the input file
			int ic1 = in.read();
			
			if (ic1 == -1) //-1 no more data
			{
				return;
			}
			
			//write the input file
			int ic2 = in.read();
			
			if (ic2 == -1) //-1 no more data
			{
				out.write(ic1);
				return;
			}
			
			processKeys(out, (char)ic1, (char)ic2);
		}
	}
	
	//process key for alphabet i and j
	public void processKeys(Writer out, char a, char b) throws IOException
	{
		int r1 = -1;
		int r2 = -1;
		int c1 = -1;
		int c2 = -1;
		
		a = Character.toLowerCase(a);
		b = Character.toLowerCase(b);
		
		if (a == 'j')
		{
			a = 'i';
		}
		
		if (b == 'j')
		{
			b = 'i';
		}
		
		for (int x = 0; x < keys.length; x++) //loops in the text char for row
		{
			for (int y = 0; y < keys[x].length; y++) //loops in the text char for col
			{
				if (keys[x][y] == a)
				{
					r1 = x;
					c1 = y;
				}
				
				if (keys[x][y] == b)
				{
					r2 = x;
					c2 = y;
				}
			}
		}
		
		if (r1 == -1 || r2 == -1)
		{
			out.write(a);
			out.write(b);
		}
		
		else
		{
			out.write(keys[r1][c2]); //print the output in file
			out.write(keys[r2][c1]); //print the output in file
		}
	}
	
	//create the key square 5x5
	public char[][] makeEncryptionKey (String k) //k is a keyword
	{
		String in = k.toLowerCase() + LETTERS; //keyword plus alphabet
		char[][] out = new char[5][5];
		int col = 0;
		int row = 0;
		
		for (int i = 0; i < in.length(); i++)
		{
			char s = in.charAt(i);
			if (s == 'j')
			{
				s = 'i';
			}
			
			if (!found(out, s))
			{
				out[col][row] = s;//row,col
				row++;//col
				if (row == out[col].length)//col,row
				{
					col++;//row
					row = 0;//col
					System.out.println(out);
				}
				//System.out.println(out);
			}
		}
		//System.out.println(out);
		return out;
		
	}
	
	//if aplhabet already in the square, it is pass
	public boolean found (char[][] square, char s)
	{
		for (int i = 0; i < square.length; i++)
		{
			for (int j = 0; j < square[i].length; j++)
			{
				if (square[i][j] != '\0' && square[i][j] == s)
				{
					return true;
				}
			}
		}
		return false;
	}	
}































































































