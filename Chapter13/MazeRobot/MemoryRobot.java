//Chapter 13 - Project 13.1

import java.util.ArrayList;

public class MemoryRobot extends Robot
{
	private ArrayList<Position> memory = new ArrayList<Position>();
	private ArrayList<Position> lastResort = new ArrayList<Position>();

	public MemoryRobot(Maze m)
	{
		current = m.FindEntrance();
		future = m.FindEntrance();
	}
	
	private Boolean checkStack (ArrayList<Position> j, Position p)
	{
		for (int i = 0; i < j.size()-1; i++)
		{
			if(j.get(i).getX() == p.getX() && j.get(i).getY() == p.getY())
			{
				return false;
			}
		}
		return true;
	}
	
	public void Move (Maze m)
	{
		int x = 1;
		long timeTaken = System.currentTimeMillis();
		
		memory.add(new Position(current.getX(), current.getY()));
		lastResort.add(new Position(current.getX(), current.getY()));
		
		while (m.getPosition(current.getX(), current.getY()) != 3)
		{
			last = lastResort.get(lastResort.size()-1);
			if(m.getPosition(current.getX(), current.getY()+1) == 1 || m.getPosition(current.getX(), current.getY()+1) == 3)
			{
				future.setPosition(current.getX(), current.getY()+1);
				if (checkStack(memory, future) == true && checkStack(lastResort, future) == true)
				{
					memory.add(new Position(current.getX(), current.getY()));
					current.setModify(0,1);
					x = 0;
				}
			}
			
			if(m.getPosition(current.getX()+1, current.getY()) == 1 || m.getPosition(current.getX()+1, current.getY()) == 3)
			{
				future.setPosition(current.getX()+1, current.getY());
				if(checkStack(memory, future) == true && checkStack(lastResort, future) == true)
				{
					memory.add(new Position(current.getX(), current.getY()));
					current.setModify(1,0);
					x = 0;
				}
			}
			
			if(m.getPosition(current.getX(), current.getY()-1) == 1 || m.getPosition(current.getX(), current.getY()-1) == 3)
			{
				future.setPosition(current.getX(), current.getY()-1);
				if(checkStack(memory, future) == true && checkStack(lastResort, future) == true)
				{
					memory.add(new Position(current.getX(), current.getY()));
					current.setModify(0,-1);
					x = 0;
				}
			}
			
			if(m.getPosition(current.getX()-1, current.getY()) == 1 || m.getPosition(current.getX()-1, current.getY()) == 3)
			{
				future.setPosition(current.getX()-1, current.getY());
				if(checkStack(memory, future) == true && checkStack(lastResort, future) == true)
				{
					memory.add(new Position(current.getX(), current.getY()));
					current.setModify(-1,0);
					x = 0;
				}
			}
			
			if(x == 1)
			{
				lastResort.add(new Position(current.getX(), current.getY()));
				memory.remove(memory.size()-1);
				current.setPosition(memory.get(memory.size()-1).getX(), memory.get(memory.size()-1).getY());
			}
			x = 1;
		}
		System.out.println("\nMemory Robot has exited the maze");
		System.out.println("Took Memory Robot " + ((System.currentTimeMillis() - timeTaken) / 1000 + " Seconds!"));
	}
}

























