//Chapter 19 - Exercise 19.13
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_13

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import javax.swing.JOptionPane;

public class StringList
{
	public static void main (String[] args)
	{
		ArrayList list = new ArrayList();
		
		boolean done = false;
		
		while (!done)
		{
			String input = JOptionPane.showInputDialog("Enter a string or Cancel");
			if (input == null)
			{
				done = true;
			}
			
			else
			{
				list.add(input);
			}
		}
		
		class StringComparator implements Comparator
		{
			public int compare(Object firstObject, Object secondObject)
			{
				String first = (String)firstObject;
				String second = (String)secondObject;
				
				if (first.length() < second.length())
				{
					return -1;
				}
				
				if (first.length() == second.length())
				{
					return first.compareTo(second);
				}
				
				return 1;
			}
		}
		
		Comparator comp = new StringComparator();
		Collections.sort(list, comp);
		
		System.out.println(list);
		System.exit(0);
	}
}