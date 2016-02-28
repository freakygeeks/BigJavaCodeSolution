//Chapter3 - Exercise P3.7
public class Student
{
	private String name;
	private double score;
	private double average;
	
	public Student()
	{
	name = " ";
	score = 0;
	}
	
	public void addName (String studName)
	{
	String newName = this.name + studName;
	this.name = newName;
	}
	
	public void addQuiz(double score1, double score2, double score3)
	{
	double newScore = this.score + score1 + score2 + score3;
	this.score = newScore;
	}
	
	public void addAverage(double quiz)
	{
	double newAverage = this.score/quiz;
	this.average = newAverage;
	}
	
	public String getName()
	{
	return this.name;
	}
	
	public double getTotalScore()
	{
	return this.score;
	}
	
	public double getAverageScore()
	{
	return this.average;
	}
}

