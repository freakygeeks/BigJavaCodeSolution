//Chapter7 - Project 7.1
//http://users.dickinson.edu/~braught/courses/cs132s03/labs/lab07.html 
//http://www.javaprogrammingforums.com/whats-wrong-my-code/13039-flesch-readability-index-code.html
//https://github.com/kenshin03/camus/blob/master/src/com/ipeirotis/readability/Readability.java
//http://monkeys.imaginary-realities.com/index.php?title=Javanomicon01_-_Case_Study_6_-_Flesch_Readability_Index *
//http://www.sfs.uni-tuebingen.de/~vhenrich/ws13-14/java/SelfTests/st10/
//http://www2.lawrence.edu/fast/GREGGJ/CMSC150/methods/intro_to_methods.html *

public class FleschDoc
{
	private double num;
	private String pub;
	private String edu;
	
	FleschDoc(double n)
	{
	num = n;
	}
	
	public static boolean vowel(char ch)
	{
	if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y')
		{
		return true;
		}
		return false;
	}	
	
	public String getPublication()
	{
	String pub = " ";
	
	if (num > 95)
		pub = "Comic";
	else if (num >= 82 && num < 95)
		pub = "Consumer Ads";
	else if (num >= 65 && num < 82)
		pub = "Sports";
	else if (num >= 57 && num < 65)
		pub = "Time";
	else if (num >= 39 && num < 57)
		pub = "New York Times";
	else if (num >= 10 && num < 39)
		pub = "Insurance Policy";
	else if (num < 10)
		pub = "Internal Revenue Code";
	else 
		System.out.println ("Bad Input");
		
	return pub;
	}
	
	public String getEducation()
	{
	String edu = " ";
	
	if (num > 91)
		edu = "5th Grader";
	else if (num >= 81 && num <= 90)
		edu = "6th Grader";
	else if (num >= 71 && num <= 80)
		edu = "7th Grader";
	else if (num >= 66 && num <= 70)
		edu = "8th Grader";
	else if (num >= 61 && num <= 65)
		edu = "9th Grader";
	else if (num >= 51 && num <= 60)
		edu = "High School Student";
	else if (num >= 31 && num <= 50)
		edu = "College Student";
	else if (num >= 0 && num <= 30)
		edu = " College Graduate";
	else if (num < 0)
		edu = " Law School Graduate";
	else
		System.out.println ("Bad Input");
		
	return edu;	
	}
}