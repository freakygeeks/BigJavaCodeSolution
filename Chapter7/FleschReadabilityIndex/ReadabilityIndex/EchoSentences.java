//package testScanner;

import java.io.File;
import java.util.Scanner;

public class EchoSentences {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("F:/JavaWorkspace/Chapter7/FleschReadabilityIndex/ReadabilityIndex/text.txt"));
        input.useDelimiter("[.!?]");
        
        int sentenceCount = 0;
        while(input.hasNext())
        {
            String sentence = input.next();
            System.out.println(sentence);
            sentenceCount++;
        }
        
        System.out.println("The text contains " + sentenceCount + " sentences.");
    }
}
