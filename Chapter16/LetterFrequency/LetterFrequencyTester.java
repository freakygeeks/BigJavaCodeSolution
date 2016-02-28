//Chapter 16 - Exercise 16.3

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LetterFrequencyTester
{
	public static void main (String[] args)
	{
		try
		{
			String file = JOptionPane.showInputDialog("Filename : ");
			FileReader inputFile = new FileReader(file);
			
			LetterFrequency freq = new LetterFrequency();
			String letters = "abcdefghijklmnopqrstuvwxyz";
			
			freq.read(inputFile);
			
			for (int i = 0; i < letters.length(); i++)
			{
				double freqNum = freq.getFrequency(letters.charAt(i));
				System.out.println(letters.charAt(i) + " : " + freqNum + "%");
			}
			
			inputFile.close();
			System.exit(0);
		}
		
		catch(IOException exception)
		{
			System.out.println(exception);
		}
	}
}