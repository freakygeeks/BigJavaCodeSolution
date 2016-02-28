import javax.swing.JOptionPane;

public class JOptionPaneReaderTester
{
	public static void main (String[] args)
	{
		String input = JOptionPane.showInputDialog("What is your name?");
		
		JOptionPaneReader nameReader = new JOptionPaneReader(input);
		
		String name = nameReader.readLine();
		
		int age = 0;
		double money = 0;
		JOptionPaneReader ageReader;
		JOptionPaneReader moneyReader;
		boolean done = false;
		
		while (!done)
		{
			try
			{
				input = JOptionPane.showInputDialog("What is your age?");
				ageReader = new JOptionPaneReader(input);
				age = ageReader.readInt();
				done = true;
			}
			
			catch (NumberFormatException exception)
			{
				System.out.println("Input age error " + exception);
			}
		}
		
		done = false;
		
		while (!done)
		{
			try 
			{
				input = JOptionPane.showInputDialog("How much money do you have?");
				moneyReader = new JOptionPaneReader(input);
				money = moneyReader.readDouble();
				done = true;
			}
			
			catch (NumberFormatException exception)
			{
				System.out.println ("Input money error " + exception);
			}
		}
		
		System.out.println (name + " is " + age + " years old " + " and has $" + money + ".");
		System.exit(0);
	}
}






























