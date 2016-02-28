//Chapter 19 - Exercise 19.12

import javax.swing.JOptionPane;
import java.util.Arrays;

public class PersonTester
{
	public static void main (String[] args)
	{
		int count = 0;
		Person[] persons = new Person[10];
		
		while (count < 10)
		{
			String input = JOptionPane.showInputDialog("Please enter the person name : ");
			
			if (input == null)
			{
				System.exit(0);
			}
			
			Person p = new Person(input);
			persons[count] = p;
			count++;
		}
		
		Arrays.sort(persons);
		System.out.println(persons[0].getName());
		System.out.println(persons[9].getName());
		
		System.exit(0);
	}
}