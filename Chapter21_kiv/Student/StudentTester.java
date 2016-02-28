//Chapter 21 - Exercise 21.5

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class StudentTester
{
	public static void main (String[] args)
	{
		Map m = new HashMap();
		boolean done = false;
		
		while (!done)
		{
			String input = JOptionPane.showInputDialog("A)dd R)emove M)odify P)rint");
			
			if (input == null)
			{
				done = true;
			}
			
			else if (input.equalsIgnoreCase("A"))
			{
				boolean done1 = false;
				
				while (!done1)
				{
					String fName = JOptionPane.showInputDialog("Enter the student first name, Cancel to quit :");
					String lName = JOptionPane.showInputDialog("Enter the student last name, Cancel to quit : ");
					String studId = JOptionPane.showInputDialog("Enter the student ID, Cancel to quit : ");
					String grade = JOptionPane.showInputDialog("Enter the student grade, Cancel to quit : ");
					
					if (fName == null || lName == null || studId == null || grade == null)
					{
						done1 = true;
					}
					
					else
					{
						int id = Integer.parseInt(studId);
						Student s = new Student(fName, lName, id);
						m.put(s, grade);
					}
				}
			}
			
			else if (input.equalsIgnoreCase("R"))
			{
				boolean done2 = false;
				
				while (!done2)
				{
					String studId = JOptionPane.showInputDialog("Enter the student ID, Cancel to quit : ");
					
					if (studId == null)
					{
						done2 = true;
					}
					
					else
					{
						int id = Integer.parseInt(studId);
						remove(id, m);
					}
				}
			}
			
			else if (input.equalsIgnoreCase("M"))
			{
				boolean done3 = false;
				
				while (!done3)
				{
					String studId = JOptionPane.showInputDialog("Enter the student ID, Cancel to quit : ");
					String grade = JOptionPane.showInputDialog("Enter the student grade, Cancel to quit : ");
					
					if (studId == null || grade == null)
					{
						done3 = true;
					}
					
					else
					{
						int id = Integer.parseInt(studId);
						modify(id, grade, m);
					}
				}
			}
			
			else if (input.equalsIgnoreCase("P"))
			{
				print(m);
			}
			
			else
			{
				done = true;
			}
		}
		
		System.exit(0);
	}
	
	//remove a student from a map
	private static void remove (int id, Map m)
	{
		int studentId = 0;
		Set keySet = m.keySet();
		Iterator iter = keySet.iterator();
		
		while (iter.hasNext())
		{
			Object key = iter.next();
			Student s = (Student) key;
			studentId = s.getId();
			
			if (studentId == id)
			{
				m.remove(s);
			}
		}
	}
	
	//modifies a student from a map
	private static void modify (int id, String grade, Map m)
	{
		int studentId = 0;
		Set keySet = m.keySet();
		Iterator iter = keySet.iterator();
		
		while (iter.hasNext())
		{
			Object key = iter.next();
			Object value = m.get(key);
			Student s = (Student) key;
			studentId = s.getId();
			
			if (studentId == id)
			{
				m.put(s, grade);
			}
		}
	}
	
	//print the contents of a map
	private static void print (Map m)
	{
		List keys = new ArrayList(m.keySet());
		Comparator comp = new StudentComparator();
		Collections.sort(keys, comp);
		
		Iterator iter = keys.iterator();
		while  (iter.hasNext())
		{
			Object key = iter.next();
			Object value = m.get(key);
			Student s = (Student) key;
			
			System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getId() + " : " + value);
		}
		
		System.out.println("");
	}
}



















