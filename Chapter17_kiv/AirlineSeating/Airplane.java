//Chapter 17 - Exercise 17.11

public class Airplane
{
	public static final int FIRST = 0;
	public static final int ECONOMY = 1;
	public static final int FIRST_ROW = 5;
	public static final int ECONOMY_ROW = 30;
	private SeatRow[] firstClass;
	private SeatRow[] economyClass;
	
	public Airplane()
	{
		firstClass = new SeatRow[FIRST_ROW];
		
		for (int i = 0; i < firstClass.length; i++)
		{
			firstClass[i] = new SeatRow(4);
		}
		
		economyClass = new SeatRow[ECONOMY_ROW];
		
		for (int i = 0; i < economyClass.length; i++)
		{
			economyClass[i] = new SeatRow(6);
		}
	}
	
	//add passenger to the airplane
	public void addPassengers (int tClass, int nPassenger, int seat)
	{
		if (tClass == FIRST)
		{
			for (int i = 0; i < firstClass.length; i++)
			{
				if (firstClass[i].addPassengers(nPassenger, seat))
				{
					return;
				}
			}
		}
		
		else
		{
			for (int i = 0; i < economyClass.length; i++)
			{
				if (economyClass[i].addPassengers(nPassenger, seat))
				{
					return;
				}
			}
		}
		
		System.out.println("Assignment did not succeed");
	}
	
	//print seating of airplane
	public void print()
	{
		for (int i = 0; i < firstClass.length; i++)
		{
			int row = i+1;
			if (row < 10)
			{
				System.out.print(" ");
			}
			
			System.out.print(row + " : ");
			firstClass[i].print();
		}
		
		for (int i = 0; i < economyClass.length; i++)
		{
			int row = FIRST_ROW + i + 1;
			if (row < 10)
			{
				System.out.print(" ");
			}
			
			System.out.print(row + " : ");
			economyClass[i].print();
		}
	}
}











