//Chapter 16 - Example 16.3

import java.io.IOException;
import java.util.Scanner;

public class EncryptorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		try
		{
			System.out.print("Input file : ");
			String inFile = in.next();
			System.out.print("Output file : ");
			String outFile = in.next();
			System.out.print("Encryption key : ");
			int key = in.nextInt();
			
			Encryptor crypt = new Encryptor(key);
			crypt.encryptFile(inFile, outFile);
			
			System.out.println(inFile);
			System.out.println(outFile);
		}
		
		catch (IOException exception)
		{
			System.out.println ("Error processing file : " + exception);
		}
	}
}