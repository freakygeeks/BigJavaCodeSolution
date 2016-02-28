//Chapter 15 - Exercise 15.5

public class InsufficientFundsException extends Exception
{
	public InsufficientFundsException() {}
	
	public InsufficientFundsException (String msg)
	{
		super(msg);
	}
}