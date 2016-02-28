//Chapter4 - Example 4.6
public class Substring
{
	public static void main (String[] args)
	{
	String greet = "Hello, World!";
	String greet1 = "Hello, \"World\"!";
	String greet2 = "C:\\\\Temp\\\\Secret.txt";
	String sub = greet.substring(0,5);
	String sub2 = greet.substring(7,12);
	String tail = greet.substring(0);
	String tail2 = greet.substring(7);
	
	System.out.println (sub);
	System.out.println (sub2);
	System.out.println (tail);
	System.out.println (tail2);
	System.out.println (greet + greet.length());
	System.out.println (greet1);
	System.out.println (greet2);
	}
}