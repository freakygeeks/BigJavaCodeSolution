//Chapter 15 - Exercise 15.2

public class BadDataException extends Exception
{
	public BadDataException() {}
	
	public BadDataException (String msg)
	{
		super(msg);
	}
}