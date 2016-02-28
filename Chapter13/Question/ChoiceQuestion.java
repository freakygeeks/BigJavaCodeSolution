//Chapter 13 - Example 13

import java.util.ArrayList;

public class ChoiceQuestion extends Question
{
	private ArrayList<String> choices;
	
	public ChoiceQuestion(String questionText)
	{
		super(questionText);
		choices = new ArrayList<String>();
	}

	public void addChoice(String choice, boolean correct)
	{
		choices.add(choice);
		if (correct)
			{
				String choiceString = "" + choices.size();
				setAnswer(choiceString);
			}
	}
	
	public void display() // override superclass method
	{
		super.display();
		for (int i = 0; i < choices.size(); i++)
			{
				int choiceNumber = i + 1;
				System.out.println (choiceNumber + ": " + choices.get(i));
			}
	}
}