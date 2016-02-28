

public class JOptionPaneReader
{
	private String input;
	
	public JOptionPaneReader (String aInput)
	{
		input = aInput;
	}
	
	public int readInt()
	{
		String inputString = readLine();
		int n = Integer.parseInt(inputString);
		
		return n;
	}
	
	public double readDouble()
	{
		String inputString = readLine();
		double x = Double.parseDouble(inputString);
		
		return x;
	}
	
	public String readLine()
	{
		return input;
	}
}