//Chapter 17 - Exercise 17.11

public class SeatRow
{
	public static final int WINDOW = 0;
	public static final int CENTER = 1;
	public static final int AISLE = 2;
	private boolean[] occupied;
	
	public SeatRow(int passengers)
	{
		occupied = new boolean[passengers];
	}
	
	//add passenger to the seat
	public boolean addPassengers (int nPassenger, int seat)
	{
		if (occupied.length < 6 && (seat == CENTER || nPassenger > 2))
		{
			return false;
		}
		
		if (nPassenger > 3) 
		{
			return false;
		}
		
		if (nPassenger == 3 && seat == CENTER)
		{
			seat = WINDOW;
		}
		
		if (seat == WINDOW)
		{
			return add(0, nPassenger-1) || add(occupied.length-nPassenger, occupied.length);
		}
		
		else if (seat == AISLE)
		{
			return add(occupied.length/2-nPassenger, occupied.length/2-1) || add(occupied.length/2, occupied.length/2+nPassenger-1);
		}
		
		else if (seat == CENTER)
		{
		return add(1-nPassenger+1, 1) || add(1, 1+nPassenger-1) || add(4, 4+nPassenger-1) || add(4-nPassenger+1,4);
		}
		
		else
		{
			return false;
		}
	}
	
	//add passenger to seat
	public boolean add(int from, int to)
	{
		for (int i = from; i <= to; i++)
		{
			if (occupied[i])
			{
				return false;
			}
		}
		
		for (int i = from; i <= to; i++)
		{
			occupied[i] = true;
		}
		
		return true;
	}
	
	//print seat row
	public void print()
	{
		for (int i = 0; i < occupied.length; i++)
		{
			if(occupied[i])
			{
				System.out.print("*");
			}
			
			else
			{
				System.out.print(".");
			}
			
			if (occupied.length == 4 || occupied.length == 6 && i == 2)
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}














