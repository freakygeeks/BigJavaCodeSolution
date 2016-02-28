//Chapter11 - Exercise P11.2

public class QuizViewer
{
	public static void main (String[] args)
	{
	DataSet quizData = new DataSet();
	
	quizData.add(new Quiz(95));
	quizData.add(new Quiz(13));
	quizData.add(new Quiz(80));
	quizData.add(new Quiz(46.9));
	quizData.add(new Quiz(32));
	
	Measure max = quizData.getMax();

	Quiz maxQuiz = (Quiz) max;
	String grade = maxQuiz.getLetterGrade();
	
	System.out.println ("Max score quiz is : " + max.getMax());
	System.out.println ("Max grade quiz is : " + grade);
	System.out.println ("Average quiz score is : " + quizData.getAverage());
	}
}