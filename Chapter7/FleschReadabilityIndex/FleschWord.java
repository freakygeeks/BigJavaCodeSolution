//Chapter7 - Project 7.1

import java.io.File;
import java.util.Scanner;

public class FleschWord
{
	public static void main (String[] args) throws Exception
	{
	//scan input from file and calculate the number of sentence
	System.out.println ("=====================================================================");
	System.out.println ("                              SENTENCES							  ");
	System.out.println ("=====================================================================");
	Scanner fileSentence = new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/sample.txt"));
	fileSentence.useDelimiter("[.:;?!]");
	double sentenceNum = 0;
	while(fileSentence.hasNext())
		{
		String sentence = fileSentence.next();
		System.out.println (sentence);
		System.out.println();
		sentenceNum++;
		}
	
	//scan input from file and calculate the number of words
	System.out.println ("=====================================================================");
	System.out.println ("                              WORDS								  ");
	System.out.println ("=====================================================================");
	Scanner fileWord =  new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/sample.txt"));
	double wordNum = 0;
	while(fileWord.hasNext())
		{
		String word = fileWord.next();
		System.out.print (word + " ");
		wordNum++;	
		}
		wordNum = wordNum;
		
	//scan input from file and calculate the number of syllable
	System.out.println ("\n" + "=====================================================================");
	System.out.println ("                            SYLLABLE								  ");
	System.out.println ("=====================================================================");
	double syllableNum = 0;
	Scanner fileSyllable =  new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/sample.txt"));
	while(fileSyllable.hasNext())
		{
			char ch = fileSyllable.next().charAt(0);
			if (FleschDoc.vowel(ch))
				{
				syllableNum++;//compute aeiouy for the first character only
				System.out.print (syllableNum + " ");
				}
				
			String allWord = fileSyllable.next();
			
			for (int i = 1; i < allWord.length(); i++)
				{
				char a = allWord.charAt(i);
				char b = allWord.charAt(i-1);
				
				if(FleschDoc.vowel(a) && !FleschDoc.vowel(b))
				syllableNum++;//compute aeiouy for all strings
				System.out.print (syllableNum + " ");
				}

			
			if (syllableNum > 0)
				{
				int lastIndex = allWord.length()-1;
				if (allWord.charAt(lastIndex) == 'e')
					{
					char c = allWord.charAt(lastIndex-1);
					if (allWord.charAt(lastIndex-1) != 'l'|| FleschDoc.vowel(c));//compute to minus e at the end of the words
					syllableNum--;
					System.out.print (syllableNum + " ");
					}
				}
		}	
		
	//scan input from file and calculate the number of syllable
	double syllableNum2 = 0;
	Scanner fileSyllable2 =  new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/sample.txt"));
	fileSyllable2.useDelimiter("[ \t\n\r0-9,.;\"\\-]");
	while(fileSyllable2.hasNext())
		{
		String syllable = fileSyllable2.next();
		if (syllable.length() > 0)
			{
			syllable = syllable.toLowerCase();
			syllableNum2++;//compute aeiouy for all strings by minus the demiliter
			}
		}
		syllableNum2 = syllableNum2 + syllableNum;
	
	//calculation for Flesch Readability index
	final double a = 206.835;
	final double b = 84.6;
	final double c = 1.015;
	double index = 0;
	
	index = a-(b*(syllableNum2/wordNum))-(c*(wordNum/sentenceNum));
	
	//the output
	System.out.println ("\n" + "=====================================================================");
	System.out.println ("                              RESULT										");
	System.out.println ("=====================================================================");
	System.out.println ("\n" + "This file contains " + sentenceNum + " sentences");
	System.out.println ("This file contains " + wordNum + " words");
	System.out.println ("This file contains " + syllableNum2 + " syllable");
	System.out.println ("Flesch index number is " + index);
	
	FleschDoc calc = new FleschDoc(index);
	System.out.println ("\n" + "The publication level is " + calc.getPublication());
	System.out.println ("The education level is " + calc.getEducation());
	}
}