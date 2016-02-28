//Chapter 16 - Exercise 16.2
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch19/c19_exp_19_1

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;

public class CaesarCipher
{
	private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final int E = 1 ;
	public static final int D = 2;
	private String key;
	private char[] keys;
	private int type;
	
	//get the key string and type of encryption or decryption
	public CaesarCipher(String aKey, int aType)
	{
		type = aType;
		key = aKey;
		keys = makeEncryptionKey(key);
	}
	
	//open both input and output file
	public void processFile (File inFile, File outFile) throws IOException
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
	
	//read the input and write output file
	public void process (Reader in, Writer out) throws IOException
	{
		while (true)
		{
			int alphabet = in.read();
			if (alphabet == -1)
			{
				out.write(alphabet);
				return;
			}
			
			if (type == E)
			{
				processEncrypt (out, (char)alphabet);
			}
			
			if (type == D)
			{
				processDecrypt (out, (char)alphabet);
			}
		}
	}
	
	//process the encryption to write the output from input
	public void processEncrypt (Writer out, char alphabet) throws IOException
	{
		int r = -1;
		
		alphabet = Character.toLowerCase(alphabet);
		
		for (int i = 0; i < LETTERS.length(); i++) //string convert to char
		{
			if (alphabet  == keys[i]) //string, char convert to string
			{
				r = i;
			}
		}
		
		if (r == -1)
		{
			out.write(alphabet);
		}
		
		else
		{
			out.write(LETTERS.charAt(r));
		}
	}
	
	//process the decryption to write the output from input
	public void processDecrypt (Writer out, char alphabet) throws IOException
	{
		int r = -1;
		
		alphabet = Character.toLowerCase(alphabet);
		
		for (int i = 0; i < keys.length; i++) //char
		{
				if (alphabet == LETTERS.charAt(i)) //string, string
				{
					r = i;
				}
		}
		
		if (r == -1)
		{
			out.write(alphabet);
		}
		
		else
		{
			out.write(keys[r]);
		}
	}
	
	//create the key cipher
	public char[] makeEncryptionKey (String k)
	{
		String newLetters = new StringBuilder(LETTERS).reverse().toString();
		
		String in = k.toLowerCase() + newLetters;
		char[] keyCipher = new char[26];
		int row = 0;
		
		for (int i = 0; i < in.length(); i++)
		{
			char alphabet = in.charAt(i);
			
			if (!foundAlphabet(keyCipher, alphabet))
			{
				keyCipher[row] = alphabet;
				row++;
				//System.out.print(row);
			}
		}
	
		//System.out.print("The cipher key : ");
		//System.out.println(keyCipher);
		return keyCipher;
	}
	
	//if alphabet already in cipher, it is pass
	public boolean foundAlphabet (char[] keyCipher, char alphabet)
	{
		for (int i = 0; i < keyCipher.length; i++)
		{
			if (keyCipher[i] != '\0' && keyCipher[i] == alphabet)
			{
				return true;
			}
		}
		
		return false;
	}
}













































