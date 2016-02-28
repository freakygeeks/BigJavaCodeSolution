//Chapter 19 - Exercise 19.14
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_14

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringListLexico
{
   public static void main(String[] args)
   {
      ArrayList<String> list = new ArrayList<String>();
      Scanner in = new Scanner(System.in);
      
      boolean done = false;      
      while (!done)
      {
         System.out.println("Enter a string or a blank line to quit");
         String input = in.nextLine();
         if (input.equals(""))
            done = true;
         else
            list.add(input);
      }

      Collections.sort(list, new StringLengthLexComparator());
      System.out.println(list);
   }
}