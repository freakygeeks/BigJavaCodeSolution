//Chapter 21 - Exercise 21.5

import java.util.Comparator;

public class StudentComparator implements Comparator
{
	//compare two student objects
	public int compare(Object obj1, Object obj2)
	{
		Student s1 = (Student)obj1;
		Student s2 = (Student)obj2;
		
		if (s1.getLastName().compareTo(s2.getLastName()) < 0)
		{
			return -1;
		}
		
		if (s1.getLastName().compareTo(s2.getLastName()) == 0)
		{
			if (s1.getFirstName().compareTo(s2.getFirstName()) < 0)
			{
				return -1;
			}
			
			if (s1.getFirstName().compareTo(s2.getFirstName()) == 0)
			{
				if (s1.getId() < s2.getId())
				{
					return -1;
				}
				
				if (s1.getId() == s2.getId())
				{
					return 0;
				}
				
				return 1;
			}
			
			return 1;
		}
		
		return 1;
	}
}










