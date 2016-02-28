//Chapter 13 - Example 13

public class Question
{
	private String text;
	private String answer;

	public Question(String questionText)
	{
		text = questionText;
		answer = "";
	}
	
	public void setAnswer (String correctResponse)
	{
		answer = correctResponse;
	}
	
	public boolean checkAnswer (String response)
	{
		return response.equals(answer);
	}

	public void display()
	{
		System.out.println(text);
	}
}