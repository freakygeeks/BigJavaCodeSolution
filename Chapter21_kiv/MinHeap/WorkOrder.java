//Chapter 21 - Example 21.9

public class WorkOrder implements Comparable
{
	//encapsulate workorder with priority
	
	private int priority;
	private String description;
	
	public WorkOrder (int aPriority, String aDescription)
	{
		priority = aPriority;
		description = aDescription;
	}
	
	public String toString()
	{
		return "priority = " + priority + " , description = " + description;
	}
	
	public int compareTo(Object otherObject)
	{
		WorkOrder other = (WorkOrder) otherObject;
		
		if (priority < other.priority)
		{
			return -1;
		}
		
		if (priority > other.priority)
		{
			return 1;
		}
		
		return 0;
	}
}