import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

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

public class PhoneLookup
{
   public static void main(String[] args) throws IOException
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of the phonebook file: ");
      String fileName = in.nextLine();
 
      LookupTable table = new LookupTable();
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