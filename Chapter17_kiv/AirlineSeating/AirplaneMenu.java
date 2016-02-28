//Chapter 17 - Exercise 17.11

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AirplaneMenu
{
	private BufferedReader console;
	
	public AirplaneMenu()
	{
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//run the system
	public void run() throws IOException
	{
		boolean more = true;
		Airplane plane = new Airplane();
		
		while (more)
		{
			System.out.println("A)add S)how Q)uit");
			String command = console.readLine().toUpperCase();
			
			if (command.equals("A"))
			{
				System.out.println ("F)irst E)conomy");
				String tclass = console.readLine().toUpperCase();
				
				if(tclass.equals("F"))
				{
				
					System.out.println ("Passengers? (1-2)");
					String input = console.readLine();
					int num = Integer.parseInt(input);
				
					System.out.println ("A)isle W)indow");
					String seat = console.readLine().toUpperCase();
				
					if (seat.equals("A"))
					{
						plane.addPassengers(Airplane.FIRST, num, SeatRow.AISLE);
					}
				
					else if (seat.equals("W"))
					{
						plane.addPassengers(Airplane.FIRST, num, SeatRow.WINDOW);
					}
				}
				
				else if (tclass.equals("E"))
				{
					System.out.println ("Passengers? (1-3)");
					String input = console.readLine();
					int num = Integer.parseInt (input);
					
					System.out.println ("A)aisle W)indow");
					String seat = console.readLine().toUpperCase();
					{
						if (seat.equals("A"))
						{
							plane.addPassengers(Airplane.ECONOMY, num, SeatRow.AISLE);
						}
						
						else if (seat.equals("C"))
						{
							plane.addPassengers(Airplane.ECONOMY, num, SeatRow.CENTER);
						}
						
						else if (seat.equals("W"))
						{
							plane.addPassengers(Airplane.ECONOMY, num, SeatRow.WINDOW);
						}
					}
				}
				
				else if (command.equals("S"))
				{
					plane.print();
				}
				
				else if (command.equals("Q"))
				{
					more = false;
				}
			}
		}
	}
}



















