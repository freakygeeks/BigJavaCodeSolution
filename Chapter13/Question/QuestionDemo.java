//Chapter 13 - Example 13

import java.util.Scanner;

public class QuestionDemo
{
	public static void main (String[] args)
	{
		Question[] quiz = new Question[2];
		
		quiz[0] = new Question ("Who was the inventor of Java?");
		quiz[0].setAnswer("James Gosling");
		
		ChoiceQuestion question  = new ChoiceQuestion("In which country was the inventor of Java born?");
		question.addChoice("Australia", false);
		question.addChoice("Canada", true);
		question.addChoice("Denmark", false);
		question.addChoice("United States", false);
		quiz[1] = question; //inheritance from ChoiceQuestion to Question
		
		Scanner in = new Scanner(System.in);
		for (Question q : quiz)
			{
				q.display();
				System.out.print ("Your answer: ");
				String response = in.nextLine();
				System.out.println (q.checkAnswer(response));
			}
	}
}