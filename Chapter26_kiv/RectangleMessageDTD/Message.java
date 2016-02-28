//Chapter 26 - Exercise 26.11

public class Message
{
	private String msg;
	private int x;
	private int y;
	
	public Message(String aMsg, int aX, int aY)
	{
		msg = aMsg;
		x = aX;
		y = aY;
	}
	
	public String getText()
	{
		return msg;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}