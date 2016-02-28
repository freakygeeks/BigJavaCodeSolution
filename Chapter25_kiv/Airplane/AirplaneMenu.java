//Chapter 25 - Exercise 25.9

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AirplaneMenu
{
	private BufferedReader console;
	private String propFile;
	
	public AirplaneMenu (String aPropFile)
	{
		console = new BufferedReader(new InputStreamReader(System.in));
		propFile = aPropFile;
	}
	
	//run system
	public void run() throws IOException, SQLException, ClassNotFoundException
	{
		boolean more = true;
		Airplane plane = new Airplane(propFile);
		
		while (more)
		{
			System.out.println("A)dd S)how Q)uit");
			String command = console.readLine().toUpperCase();
			
			if (command.equals("A"))
			{
				System.out.println("F)irst E)conomy");
				String tclass = console.readLine().toUpperCase();
				
				if (command.equals("A"))
				{
					System.out.println("Passengers ? (1-2)");
					String input = console.readLine();
					int num = Integer.parseInt(input);
					System.out.println("A)isle W)indow");
					String seat_pref = console.readLine().toUpperCase();
					
					if (seat_pref.equals("A"))
					{
						plane.addPassengers(Airplane.FIRST, num, FSeatRow.AISLE);
					}
					else if (seat_pref.equals("W"))
					{
						plane.addPassengers(Airplane.FIRST, num, FSeatRow.WINDOW);
					}
				}
				else if (tclass.equals("E"))
				{
					System.out.println("Passengers? (1-3)");
					String input = console.readLine();
					int num = Integer.parseInt(input);
					System.out.println("A)isle C)enter W)indow");
					String seat_pref = console.readLine().toUpperCase();
					
					if (seat_pref.equals("A"))
					{
						plane.addPassengers(Airplane.ECONOMY, num, ESeatRow.AISLE);
					}
					else if (seat_pref.equals("C"))
					{
						plane.addPassengers(Airplane.ECONOMY, num, ESeatRow.CENTER);
					}
					else if (seat_pref.equals("W"))
					{
						plane.addPassengers(Airplane.ECONOMY, num, ESeatRow.WINDOW);
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













