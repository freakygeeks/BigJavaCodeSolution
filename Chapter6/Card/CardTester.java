//Chapter6 - Exercise P6.2
import java.util.Scanner;

public class CardTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter your first card letter : ");
	String letter1 = in.nextLine();
	
	System.out.print ("Enter your second card letter : ");
	String letter2 = in.nextLine();
	
	Card desc = new Card(letter1, letter2);
	System.out.println(desc.getDescription1() + " of " + desc.getDescription2());
	}
}