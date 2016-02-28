//Chapter1 - Exercise P1.6
/* Write a program that computes the sum of the reciprocals 1/1 + 1/2..1/10. This is harder that it sounds.
Try writing the program and check the result. The program's result isn't likely to be correct.
Then write the denominators as floating-point numbers, 1.0,2.0..10.0 and run the program again. */

//start with public class name ProgramReciprocals
public class ProgramReciprocals
{
	//define a static main method using String[] args to print a command line arguments
	public static void main (String[] args)
	{
	//define a System.out object, println method and paramters to print out the statement
	System.out.print ("The sum of first ten reciprocals are : ");
	System.out.println (1.0/1.0 + 1.0/2.0 + 1.0/3.0 + 1.0/4.0 + 1.0/5.0 + 1.0/6.0 + 
	1.0/7.0 + 1.0/8.0 + 1.0/9.0 + 1.0/10.0);
	}
}