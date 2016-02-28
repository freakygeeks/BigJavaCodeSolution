//package testScanner;

import java.io.File;
import java.util.Scanner;

public class EchoWords {

  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/ReadabilityIndex/text.txt"));

    while (input.hasNext()) {
      String word = input.next();
      System.out.println(word);
    }

  }
}
