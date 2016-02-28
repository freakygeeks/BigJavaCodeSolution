//Chapter2 - Exercise P2.10
public class SwitchLetters
{
	public static void main (String[] args)
	{
	String letter = "Hello, World!";
	String letter1 = letter.replace("o","e");
	String letter2 = letter1.replace("He","Ho");
	
	System.out.print (letter2);
	}
}