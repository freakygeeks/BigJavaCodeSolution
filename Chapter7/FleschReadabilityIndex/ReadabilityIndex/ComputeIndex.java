//package fleschIndex;

import java.io.File;
import java.util.Scanner;

public class ComputeIndex {

  public static int countWordsInSentence(String text) {
    int wordCount = 0;
    Scanner s = new Scanner(text);
    s.useDelimiter("[ \t\n\r0-9,.;\"\\-]");
    while (s.hasNext()) {
      String word = s.next();
      if (word.length() > 0) {
        wordCount++;
      }
    }
    return wordCount;
  }

  public static boolean isVowel(char ch) {
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
      return true;
    }
    return false;
  }

  public static int countSyllablesInWord(String word) {
    int count = 0;
    int index;

    // Count the vowel groups
    if (isVowel(word.charAt(0))) {
      count++;
    }
    for (index = 1; index < word.length(); index++) {
      if (isVowel(word.charAt(index)) && !isVowel(word.charAt(index - 1))) {
        count++;
      }
    }

    if (count > 1) {
      // Check for the terminal 'e' exception
      int lastIndex = word.length() - 1;
      if (word.charAt(lastIndex) == 'e') {
        // Check for the 'le' exception
        if (word.charAt(lastIndex - 1) != 'l' || isVowel(word.charAt(lastIndex - 2))) {
          count--;
        }
      }
    }
    return count;
  }

  public static int countSyllablesInSentence(String text) {
    int syllableCount = 0;
    Scanner s = new Scanner(text);
    s.useDelimiter("[ \t\n\r0-9,.;\"\\-]");
    while (s.hasNext()) {
      String word = s.next();
      if (word.length() > 0) {
        word = word.toLowerCase();
        syllableCount = syllableCount + countSyllablesInWord(word);
      }
    }
    return syllableCount;
  }

  public static void main(String[] args) throws Exception {
    int sentenceCount;
    int wordCount;
    int syllableCount;

    // Set up the scanner
    Scanner input = new Scanner(new File("F:/text.txt"));
    input.useDelimiter("[.!?]");

    // Initialize the counters
    sentenceCount = 0;
    wordCount = 0;
    syllableCount = 0;

    // Scan the input file
    while (input.hasNext()) {
      String sentence = input.next();
      sentenceCount++;
      wordCount = wordCount + countWordsInSentence(sentence);
      syllableCount = syllableCount + countSyllablesInSentence(sentence);
    }

    // Compute the Flesch Readability Index
    double fleschIndex = 206.835
            - (84.6 * syllableCount) / wordCount
            - (1.015 * wordCount) / sentenceCount;
    
    // Print results
    System.out.println("This text has an index of " + fleschIndex);
    System.out.println("Syllables per word average " + (1.0 * syllableCount) / wordCount);
    System.out.println("Words per word sentence average " + (1.0 * wordCount) / sentenceCount);
  }
}
