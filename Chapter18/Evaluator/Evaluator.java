//Chapter 18 - Example 18.5

public class Evaluator
{
	private ExpressionTokenizer token;
	
	public Evaluator(String anExpression)
	{
		token = new ExpressionTokenizer(anExpression);
	}
	
	//evaluate the expression
	public int getExpressionValue()
	{
		int value = getTermValue();
		boolean done = false;
		while(!done)
		{
			String next = token.peekToken();
			
			if("+".equals(next) || "-".equals(next))
			{
				token.nextToken();
				int value2 = getTermValue();
				
				if("+".equals(next))
				{
					value = value + value2;
				}
				
				else
				{
					value = value - value2;
				}
			}
			
			else
			{
				done = true;
			}
		}
		
		return value;
	}
	
	//evaluates the next term found in the expression
	public int getTermValue()
	{
		int value = getFactorValue();
		boolean done = false;
		while(!done)
		{
			String next = token.peekToken();
			
			if("*".equals(next) || "/".equals(next))
			{
				token.nextToken();
				int value2 = getFactorValue();
				
				if("*".equals(next))
				{
					value = value * value2;
				}
				
				else
				{
					value = value/value2;
				}
			}
			
			else
			{
				done = true;
			}
		}
		
		return value;
	}
	
	//evaluates the next factor found in the expression
	public int getFactorValue()
	{
		int value;
		String next = token.peekToken();
		
		if ("(".equals(next))
		{
			token.nextToken();
			value = getExpressionValue();
			token.nextToken();
		}
		
		else
		{
			value = Integer.parseInt(token.nextToken());
		}
		
		return value;
	}
}