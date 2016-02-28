import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JOptionPane;

/* The input file has the format

Abbott, Amy
408-924-1669
Abeyta, Ric
408-924-2185
Abrams, Arthur
408-924-6120
Abriam-Yago, Kathy
408-924-3159
Accardo, Dan
408-924-2236
Acevedo, Elvira
408-924-5200
Acevedo, Gloria
408-924-6556
Achtenhagen, Stephen
408-924-3522
. . .

*/

public class Tester
{  
   public static void main(String[] args)
   {
      String fileName = JOptionPane.showInputDialog(
        "Enter the name of the phonebook file: ");
      if (fileName == null)
        System.exit(0);
 
      LookupTable names = new LookupTable();
      try
      {
         FileReader in = new FileReader("F:\\JavaWorkspace\\Chapter19\\BinaryTelephone\\test1\\input.txt");
         names.read(new BufferedReader(in));
      }
      catch (IOException exception)
      {  
         System.out.println(exception);
         System.exit(1);
      }
      LookupTable numbers = new LookupTable();
      numbers.reverse(names);
      boolean more = true;
      while (more)
      {  
         String cmd = JOptionPane.showInputDialog(
            "Lookup N)ame, P)hone number, Q)uit?");
         if (cmd == null)
            more = false;
            
         else if (cmd.equalsIgnoreCase("Q")) 
            more = false;
         else if (cmd.equalsIgnoreCase("N"))
         { 
            String n = JOptionPane.showInputDialog(
               "Enter name:");
            System.out.println("Phone number: " + names.lookup(n));
         }
         else if (cmd.equalsIgnoreCase("P"))
         { 
            String n = JOptionPane.showInputDialog(
               "Enter phone number:");
            System.out.println("Name: " + numbers.lookup(n));
         }
      }
      
      System.exit(0);
   }
}
