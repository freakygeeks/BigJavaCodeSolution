//Chapter 17 - Exercise 17.8

public class Message
{
	private String recipient;
	private String sender;
	private String title;
	private String text;
	
	public Message(String aRecipient, String aSender, String aTitle, String aText)
	{
		recipient = aRecipient;
		sender = aSender;
		title = aTitle;
		text = aText;
	}
	
	public String getRecipient()
	{
		return recipient;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	public boolean match (String Title)
	{
		return title.equals(Title);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getText()
	{
		return text;
	}
	
	@Override
	public String toString()
	{
		return title;
	}
}