//Chapter 18 - Project 18.1

public class ExpressionTokenizer
{
	private String input;
	private int start;
	private int end;
	
	public ExpressionTokenizer(String anInput)
	{
		input = anInput;
		start = 0;
		end = 0;
		nextToken();
	}
	
	//peek at the next token without consuming it
	public String peekToken()
	{
		if (start >= input.length())
		{
			return null;
		}
		
		else
		{
			return input.substring(start, end);
		}
	}
	
	//get the next token and moves the tokenizer to the following token
	public String nextToken()
	{
		String r = peekToken();
		start = end;
		
		if (start >= input.length())
		{
			return r;
		}
		
		if (Character.isDigit(input.charAt(start)))
		{
			end = start + 1;
			while (end < input.length() && Character.isDigit(input.charAt(end)))
			{
				end++;
			}
		}
		
		else
		{
			end = start + 1;
		}
		
		return r;
	}
}