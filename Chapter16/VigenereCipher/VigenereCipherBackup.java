//Chapter 16 - Exercise 16.4
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch19/c19_exp_19_3
//http://www.it2051229.com/monovigenerecipher.html
//http://www.sanfoundry.com/java-program-implement-vigenere-cypher/

import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class VigenereCipher
{
	private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final int E = 1;
	public static final int D = 2;
	private String key;
	private String keys;
	private String keyCipher;
	private String inputText;
	private int type;
	private int count;

	//get the key string and type of encryption or decryption
	public VigenereCipher (final String aKey, int aType)
	{
		key = aKey;
		keys = makeEncryptionKey(key);
		type = aType;
	}
	
	//create the key cipher
	public String makeEncryptionKey (String k)
	{
		String inputKey = k.toLowerCase();
		String result = "";
		String cipher = "";
		System.out.println();
		
		for(int i = 0; i < inputKey.length(); i++) //loop using key length
		{
			char alphabet = inputKey.charAt(i);

			for (int j = 0; j < LETTERS.length(); j++) //loop in letter length
			{				
				if (alphabet == LETTERS.charAt(j))//if key = letter
				{
					result = LETTERS.substring(j) + LETTERS.substring(0,j); //get the keystring
				}
			}
			cipher = cipher + result;//plus each of keystring in loop
		}	
		keyCipher = cipher;
		//System.out.println("Key Cipher : " + cipher);
		return keyCipher;
	}
	
	//open both input and output file
	public void processFile (File inFile, File outFile) throws IOException
	{
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try
		{
			in = new FileInputStream(inFile);
			out = new FileOutputStream(outFile);
			process(in,out);
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
	
	//read the input output file
	public void process (InputStream in, OutputStream out) throws IOException
	{
		String input = "";
		
		while (true)
		{
			int alphabet = in.read();
			input = input + (char)alphabet;
			
			if (alphabet == -1)
			{
				getText(out, input);
				return;
			}
		}
	}
	
	//get the message text for decryption/encryption
	public String getText(OutputStream out, String k) throws IOException
	{
		String trimInputText = k.toLowerCase().replace(" ", "").replace("\n","").replace("\r","");
		inputText = trimInputText; 
		//System.out.println("Text : " + inputText + " Substring : " +  inputText.substring(0, inputText.length()));
		
			if (type == E)
			{
				processEncrypt (out);
			}
			
			if (type == D)
			{
				processDecrypt (out);
			}
		
		return inputText;
	}	
	
	//process the encryption to write the output result
	public void processEncrypt (OutputStream out) throws IOException
	{
		for (int i = 0; i < inputText.length(); i++)
		{
			int r = (LETTERS.length()*(i%key.length()));
			char c = inputText.charAt(i);
						
			for (int j = 0; j < LETTERS.length(); j++)
			{
				if(c == LETTERS.charAt(j))
				{
					out.write(keyCipher.charAt(j+r));
				}
			}
		}
	}
	
	//process the decryption to write the output result
	public void processDecrypt (OutputStream out) throws IOException
	{
		for (int i = 0; i < inputText.length(); i++)
		{
			int r = LETTERS.length()*(i%key.length());
			int s = (LETTERS.length()*(i%key.length()))+(LETTERS.length()-1);
			char c = inputText.charAt(i);
			
			//System.out.println(r + " : " + s);
			String cipherChunk = keyCipher.substring(r,s);
						
			for (int j = 0; j < cipherChunk.length(); j++)
			{
				if(c == cipherChunk.charAt(j))
				{
					out.write(LETTERS.charAt(j));
				}
			}
		}
	}
	//CIBE JMGRI XNQJICBVKW [9, 26, 73] key, [9,0, 21] letters
	//JAVA STYLE GUIDELINES
}


















