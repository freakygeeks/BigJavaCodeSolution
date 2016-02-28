//Chapter7 - Exercise P7.2

import java.util.Random;

public class RandomWalkTester 
{
    public static void main(String[] args) 
	{
	final int NORTH = 0;
	final int EAST = 1;
	final int SOUTH = 2;
	final int WEST = 3;	
	
    Random gen = new Random(); 
    RandomWalk drunkard = new RandomWalk(); 
    
	int direction; 
    for (int i = 0; i < 100; i++) 
	{
        direction = gen.nextInt(4); 
        if (direction == NORTH)
		{ 
        drunkard.moveNorth();
        } 
		else if (direction == EAST) 
		{ 
        drunkard.moveEast(); 
        } 
		else if (direction == SOUTH)
		{ 
        drunkard.moveSouth();
        } 
		else if (direction == WEST) 
		{ 
        drunkard.moveWest();
        } 
		else 
		{
        System.out.println("Impossible!"); 
        }      
    } 
    drunkard.getDrunk();
    }

} 