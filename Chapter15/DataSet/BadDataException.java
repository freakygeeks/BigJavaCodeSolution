//Chapter 15 - Example 15.6

public class BadDataException extends Exception
{
	public BadDataException() {}
	
	public BadDataException(String msg)
	{
		super(msg);
	}
}