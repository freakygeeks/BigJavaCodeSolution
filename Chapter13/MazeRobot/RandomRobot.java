//Chapter 13 - Project 13.1

import java.util.Random;

public class RandomRobot extends Robot
{
	int x = 0;
	int y = 0;

	public RandomRobot(Maze m) //get the input of Maze class
	{
		current = m.FindEntrance();
		future = m.FindEntrance();
	}
	
	public void Move (Maze m) //get the input of Maze class
	{
		int stepWay = 0;
		int stepMove = 0;
		Random num = new Random();
		long timeTaken = System.currentTimeMillis();
		
		while (m.getPosition(current.getX(), current.getY()) != 3)
		{
			stepWay = num.nextInt(4);
			
			switch(stepWay)
			{
				case 0 : 
						future.setModify(1,0);
						if(m.getPosition(future.getX(), future.getY()) == 1 || m.getPosition(future.getX(), future.getY()) == 3)
						{
							current.setModify(1,0);
						}
						else
						{
							future.setModify(-1,0);
						}
						break;
				case 1 :
						future.setModify(0,1);
						if(m.getPosition(future.getX(), future.getY()) == 1 || m.getPosition(future.getX(), future.getY()) == 3)
						{
							current.setModify(0,1);
						}
						else
						{
							future.setModify(0,-1);
						}
						break;
				case 2 :
						future.setModify(-1,0);
						if(m.getPosition(future.getX(), future.getY()) == 1 || m.getPosition(future.getX(), future.getY()) == 3)
						{
							current.setModify(-1,0);
						}
						else
						{
							future.setModify(1,0);
						}
						break;
				case 3 :
						future.setModify(0,-1);
						if(m.getPosition(future.getX(), future.getY()) == 1 || m.getPosition(future.getX(), future.getY()) == 3)
						{
							current.setModify(0,-1);
						}
						else
						{
							future.setModify(0,1);
						}
						break;
				default	:
							System.out.println("Random. You have failed me for the last time...AGAIN!!");
							System.exit(1);
							break;
						
			}
			stepMove++;
		}
		System.out.println("\nRandom Robot has exited the maze");
		System.out.println("Took Random Robot " + ((System.currentTimeMillis() - timeTaken) / 1000 + " Seconds!"));
		System.out.println("Took " + stepMove + " moves");
	}	
}