import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConsoleReader
{
	private BufferedReader reader;
	
	public ConsoleReader(InputStream inStream)
	{
		reader = new BufferedReader (new InputStreamReader(inStream));
	}
	
	public String readLine()
	{
		String inputLine = "";
		
		try
		{
			inputLine = reader.readLine();
		}
		
		catch (IOException exception)
		{
			return null;
		}
		
		return inputLine;
	}
}