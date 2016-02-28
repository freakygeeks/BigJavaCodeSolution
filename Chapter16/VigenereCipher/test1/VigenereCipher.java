//Chapter 16 - Exercise 16.4
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch19/c19_exp_19_3
//http://www.it2051229.com/monovigenerecipher.html
//http://www.sanfoundry.com/java-program-implement-vigenere-cypher/

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;

public class VigenereCipher
{
	private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final int E = 1;
	public static final int D = 2;
	private String key;
	private String outputResult;
	private String inputText;
	private char[] keys;
	private int type;
	private int count;
	
	//get the key string and type of encryption or decryption
	public VigenereCipher (final String aKey, int aType)
	{
		key = aKey;
		keys = makeEncryptionKey(key);
		type = aType;
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
			if (in !=null)
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
			count++;
			int alphabet = in.readNext();
			if (alphabet == -1)
			{
				out.write(alphabet);
				return;
			}
			
			if (type == E)
			{
				textEncrypt (out, (char)alphabet);
			}
			
			if (type == D)
			{
				textDecrypt (out, (char) alphabet);
			}
		}
		
		/*int alphabet;
		do
		{
			alphabet = in.read();
			inputText = inputText + (char)alphabet;
			System.out.println((char)alphabet);

			if (alphabet != -1)
			{
				out.write(alphabet);
			}
		}
		
		while (alphabet != -1);
		textDecrypt();*/
	}
	
	//get the message text for decryption
	public void textDecrypt(Writer out, char alphabet) throws IOException
	{
		alphabet = Character.toLowerCase(alphabet);
		inputText = Character.toString(alphabet);
		processDecrypt(out);
	}
	
	//process the decryption to write the output to file
	public void processDecrypt (Writer out) throws IOException
	{
		String textDecrypt = inputText;
		out.write(textDecrypt);
		//System.out.println(key.length() + " : " + keys.length + " : " + textDecrypt.length());
		
		for (int i = 0; i < count; i++)
		{
			System.out.println(i);
		}
		
	}
	
	//get the message text for encryption
	public void textEncrypt(Writer out, char alphabet) throws IOException
	{
		alphabet = Character.toLowerCase(alphabet);
		inputText = Character.toString(alphabet);
		System.out.print(inputText);
		processEncrypt(out);
	}
	
	//process the encryption to write the output to file
	public void processEncrypt (Writer out) throws IOException
	{
		String textEncrypt = inputText;
		out.write(textEncrypt);
	}
	
	//create the key cipher
	public char[] makeEncryptionKey (String k)
	{
		String inputKey = k.toLowerCase();
		int col = 0;
		int num = LETTERS.length()*inputKey.length()+1;
		char[] keyCipher = new char[num]; //allocate char for key [row][col]

		System.out.println();
		
		for(int i = 0; i < inputKey.length(); i++) //loop using key length
		{
			char alphabet = inputKey.charAt(i);

			for (int j = 0; j < LETTERS.length(); j++) //loop in letter length
			{				
				if (alphabet == LETTERS.charAt(j))//if key = letter
				{
					outputResult = LETTERS.substring(j) + LETTERS.substring(0,j); //get the keystring
					//System.out.println(output);
					
					for (int x = 0; x < outputResult.length(); x++)
					{
						col++;
						char outputKey = outputResult.charAt(x);
						keyCipher[col] = outputKey;
						//System.out.println(col);
						//System.out.println(output.length() + "" + alphabet + "" + output);
					}
				}
			}
		}

		//System.out.println(keyCipher);
		return keyCipher;
	}
}








