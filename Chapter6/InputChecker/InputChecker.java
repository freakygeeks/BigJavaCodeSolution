//Chapter 6 - Exercise P6.7

public class InputChecker
{
	private String ans;
	
	public InputChecker(String answer)
	{
	ans = answer;
	}
	
	public String getCheck()
	{
	String a = " ";
	
	if (ans.equalsIgnoreCase("Y"))
		a = "OK";
	else if (ans.equalsIgnoreCase("Yes"))
		a = "OK";
	else if (ans.equalsIgnoreCase("OK"))
		a = "OK";
	else if (ans.equalsIgnoreCase("Sure"))
		a = "OK";
	else if (ans.equalsIgnoreCase("Why not"))
		a = "OK";
	else if (ans.equalsIgnoreCase("N"))
		a = "Terminating";
	else if (ans.equalsIgnoreCase("No"))
		a = "Terminating";
	else
	{
		System.out.println ("Bad input!");
	}
	
	return a;
	}
}