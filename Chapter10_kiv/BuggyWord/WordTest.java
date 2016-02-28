//Chapter 10 - Exercise 10.9

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
   This program tests the countSyllables method of the Word class.
*/
public class WordTest
{
   public static void main(String[] args)
   {
      String input
         = JOptionPane.showInputDialog("Enter a sentence");
      StringTokenizer tokenizer = new StringTokenizer(input);
      while (tokenizer.hasMoreTokens())
      {
         String token = tokenizer.nextToken();
         Word w = new Word(token);
         int syllables = w.countSyllables();
         System.out.println("Syllables in " + token + ": "
            + syllables);
      }
      System.exit(0);
   }
}
