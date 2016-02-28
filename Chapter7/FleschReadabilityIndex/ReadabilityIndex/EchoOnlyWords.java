//package testScanner;

import java.io.File;
import java.util.Scanner;

public class EchoOnlyWords {

  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/fleschIndex/text.txt"));
    input.useDelimiter("[ \t\n\r0-9,.\"\\-]");

    while (input.hasNext()) {
      String word = input.next();
      if (word.length() > 0) {
        System.out.println(word);
      }
    }

  }
}
