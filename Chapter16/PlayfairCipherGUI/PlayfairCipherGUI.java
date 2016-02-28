//Chapter 16 - Exercise 16.12
//http://www.dreamincode.net/forums/topic/190728-secret-code-iii-playfair-code/
//http://www.codemiles.com/java/playfair-cipher-technique-t101.html
//https://code.google.com/p/playfair-cipher/source/browse/trunk/Playfair+Cipher/?r=7#Playfair%20Cipher%2Fsrc%2Fplayfaircipher
//http://en.wikipedia.org/wiki/Playfair_cipher

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.Reader;
import java.io.Writer;
import javax.swing.JPanel;
import java.awt.Dimension;

public class PlayfairCipherGUI extends JPanel
{
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private String key;
	private char[][] keys;
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	
	public PlayfairCipherGUI()
	{
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
	}
	
	public void getKey (String aKey)
	{
		key = aKey;
		keys = makeEncryptionKey (key);
	}
	
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
		while(true)
		{
			int char1 = in.read();
			if (char1 == -1)
			{
				return;
			}
			
			int char2 = in.read();
			if (char2 == -1)
			{
				out.write(char1);
				return;
			}
			
			processKeys(out, (char)char1, (char)char2);
		}
	}
	
	public void processKeys (Writer out, char data1, char data2) throws IOException
	{
		int r1 = -1;
		int r2 = -1;
		int c1 = -1;
		int c2 = -1;
		
		data1 = Character.toLowerCase(data1);
		data2 = Character.toLowerCase(data2);
		
		if (data1 == 'j')
		{
			data1 = 'i';
		}
		
		if (data2 == 'j')
		{
			data2 = 'i';
		}
		
		for (int x = 0; x < keys.length; x++)
		{
			for (int y = 0; y < keys.length; y++)
			{
				if (keys[x][y] == data1)
				{
					r1 = x;
					c1 = y;
				}
				
				if (keys[x][y] == data2)
				{
					r2 = x;
					c2 = y;
				}
			}
		}
		
		if (r1 == -1 || r2 == -1)
		{
			out.write(data1);
			out.write(data2);
		}
		
		else
		{
			out.write(keys[r1][c2]);
			out.write(keys[r2][c1]);
		}
	}
	
	public char[][] makeEncryptionKey (String k)
	{
		String in = k.toLowerCase() + LETTERS;
		char[][] out = new char[5][5];
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < in.length(); i++)
		{
			char keyAlphabet = in.charAt(i);
			if (keyAlphabet == 'j')
			{
				keyAlphabet = 'i';
			}
			
			if (!foundAlphabet(out, keyAlphabet))
			{
				out[row][col] = keyAlphabet;
				col++;
				
				if (col == out[row].length)
				{
					row++;
					col = 0;
				}
			}
		}
		
		return out;
	}
	
	public boolean foundAlphabet (char[][] square, char keyAlphabet)
	{
		for (int i = 0; i < square.length; i++)
		{
			for (int j = 0; j < square[i].length; j++)
			{
				if (square[i][j] != '\0' && square[i][j] == keyAlphabet) //'\0' is a null character
				{
					return true;
				}
			}
		}
		
		return false;
	}
}









































