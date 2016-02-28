//Chapter 16 - Exercise 16.1

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileCounterTester
{
	public static void main (String[] args)
	{
		String input = " ";
		
		try
		{
			boolean done = false;
			while(!done)
			{
				try
				{
					input = JOptionPane.showInputDialog("Filename : ");
					
					if (input.equals(" "))
					{
						done = true;
					}
				}
				
				catch (Exception exception)
				{
					System.exit(0);
				}
				
				FileReader fileName = new FileReader(input);
				FileCounter fileCount = new FileCounter();
				fileCount.read(fileName);
				
				System.out.println (fileCount.getCharacterCount() + " chars " + fileCount.getWordCount() + " words " + fileCount.getLineCount() + " lines ");
				
				fileName.close();
				
			}
		}
		
		catch (IOException exception)
		{
			System.out.println (exception);
		}
	}
}




















