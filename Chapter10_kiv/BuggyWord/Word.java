//Chapter 10 - Exercise 10.9

import java.util.logging.Logger;

/**
   This class describes words in a document.
   Similar to using the debugger, adding logging messages to the program
      can help find bugs.  By logging the info of the variables i, j, text,
      end, and ch, one can find 2 errors. The messages are informative
      enough to spot the bugs.  For example, when the user inputs "hello",
      the logging messages state that the variables text = "hell" and
      ch = "l" when the user knows that the text variable is suppose to
      contain the string "hello" and ch = "o", the last character in the
      string. The user can thus understand why "hello" returns only 1 syllable.
 */

public class Word
{
   /**
      Constructs a word by removing leading and trailing non-
         letter characters, such as punctuation marks.
      @param s the input string
   */
   
    private String text;
	private Logger logger;
   
   public Word(String s)
   {
      logger = Logger.getLogger("global");
      int i = 0;
      logger.info("i:" + i);
      while (i < s.length()
         && !Character.isLetter(s.charAt(i)))
      i++;
      logger.info("i++:" + i);
      int j = s.length() - 1;
      logger.info("j:" + j);
      while (j > i
         && !Character.isLetter(s.charAt(j)))
      j--;
      logger.info("j--:" + j);
      text = s.substring(i, j);
      logger.info("text:" + text);
   }

   /**
      Returns the text of the word, after removal of the
         leading and trailing non-letter characters.
      @return the text of the word
   */
   public String getText()
   {
      return text;
   }

   /**
      Counts the syllables in the word.
      @return the syllable count
   */
   public int countSyllables()
   {
      int count = 0;
      int end = text.length() - 1;
      logger.info("end:" + end);

      if (end < 0) return 0; // the empty string has no syllables

      // an e at the end of the word doesn't count as a vowel
      char ch = Character.toLowerCase(text.charAt(end));
      logger.info("ch:" + ch);

      if (ch == 'e') end--;
      logger.info("end:" + end);

      boolean insideVowelGroup = false;
      for (int i = 0; i <= end; i++)
      {
         ch = Character.toLowerCase(text.charAt(i));
         String vowels = "aeiouy";
         if (vowels.indexOf(ch) >= 0)
         {
            // ch is a vowel
            if (!insideVowelGroup)
            {
               // start of new vowel group
               count++;
               insideVowelGroup = true;
            }
         }
      }

      // every word has at least one syllable
      if (count == 0)
         count = 1;

      return count;
   }
}
