//Chapter 19 - Exercise 19.5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class MergeSorterTester2
{
   public static void main(String[] args) throws IOException
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of the phonebook file: ");
      String fileName = in.nextLine();
 
      LookupTable table = new LookupTable(100);
      FileReader reader = new FileReader(fileName);
      table.read(new Scanner(reader));
      
      boolean more = true;
      while (more)
      {  
         System.out.println("Lookup N)ame, P)hone number, Q)uit?");
         String cmd = in.nextLine();
           
         if (cmd.equalsIgnoreCase("Q")) 
            more = false;
         else if (cmd.equalsIgnoreCase("N"))
         { 
            System.out.println("Enter name:");
            String n = in.nextLine();
            System.out.println("Phone number: " + table.lookup(n));
         }
         else if (cmd.equalsIgnoreCase("P"))
         { 
            System.out.println("Enter phone number:");
            String n = in.nextLine();
            System.out.println("Name: " + table.reverseLookup(n));
         }
      }
   }
}