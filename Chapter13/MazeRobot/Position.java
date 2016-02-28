//Chapter 13 - Project 13.1
//https://www.techshopbd.com/tutorial-categories/robotics/19/maze-solving-robot-techshop-bangladesh
//http://www.cs.colby.edu/srussell/cs151/Proj6/Project6.htm

public class Position
{
	private int x;
	private int y;
	
	public Position()
	{
		x = 0;
		y = 0;
	}
	
	public Position (int a, int b)
	{
		x = a;
		y = b;
	}
	
	public void setModify (int a, int b)
	{
		x = x + a;
		y = y + b;
	}
	
	public void setPosition (int a, int b)
	{
		x = a;
		y = b;
	}
	
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	/*check the position with Maze class for change the direction,
	this function is created after Maze class is created*/ 
	public int getDirection (Maze m, int direction)
	{
		switch (direction)
		{
			case 0 : return m.getPosition(x, y-1);
			case 1 : return m.getPosition(x+1, y);
			case 2 : return m.getPosition(x, y+1);
			case 3 : return m.getPosition(x-1, y);
		}
		return -2;
	}
}