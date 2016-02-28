
public class ConsoleReaderTester
{
	public static void main (String[] args)
	{
		ConsoleReader reader = new ConsoleReader(System.in);
		
		System.out.print ("What is your name?");
		String input = reader.readLine();
	
		System.out.println (input);
	}
}