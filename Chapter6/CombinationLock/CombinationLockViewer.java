//Chapter6 - Project P6.1

import java.util.Scanner;

public class CombinationLockViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.println ("This lock can be open by dialling three time using 26 dial" + "\n" + "alphabet range from a Capital letter A until Z" + "\n");
	System.out.print ("Please enter your first dial : ");
	String input1 = in.nextLine();
	
	System.out.print ("Please enter your second dial : ");
	String input2 = in.nextLine();
	
	System.out.print ("Please enter your third dial : ");
	String input3 = in.nextLine();
	System.out.println ();
	
	CombinationLock calc = new CombinationLock(input1, input2, input3);
	System.out.println (calc.getLock());
	calc.isOpen();
	}
}