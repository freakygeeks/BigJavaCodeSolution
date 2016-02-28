//Chapter3 - Exercise P3.7
public class StudentTester
{
	public static void main(String[] args)
	{
	Student stud = new Student();
	stud.addName("Siti");
	stud.addQuiz(28,29,27);
	stud.addAverage(3);
	
	String Name = stud.getName();
	double TotalScore = stud.getTotalScore();
	double AverageScore = stud.getAverageScore();
	
	System.out.println ("Student name : " + Name + ", Total Score : " + TotalScore + ", Average Score : " + AverageScore);
	}
}