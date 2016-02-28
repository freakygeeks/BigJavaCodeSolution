//Chapter8 - Project P8.2

import java.util.Scanner;

public class GameOfLifeViewer
{
    public static void main(String[] args)
	{
		GameOfLife calc = new GameOfLife();
		Scanner in = new Scanner(System.in);
		
		boolean[][] world = calc.gen();//random input for cell
        calc.show(world); //print the output
        System.out.println(); 

		boolean done = false;
		while(!done)
		{
			System.out.print ("Press 'ENTER' to continue or 'Q' to quit : ");
			String input = in.nextLine();
			if (input.equalsIgnoreCase("Q"))
			{
				done = true;
			}
			else //(input.nextLine().length() == 0)
			{
			System.out.println();
			world = calc.nextGen(world);
			calc.show(world);
			}		
		}		
    }
}