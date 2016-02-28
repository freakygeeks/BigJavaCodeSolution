//Chapter 13 - Project 13.1

public class Robot
{
	/*current and future is variable used by RandomRobot*/
	protected Position current;
	protected Position future;

	/* direction is variable used by RightHandMoveRobot*/
	int direction = 0;
	protected Position last;
	
	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;
	
	//method that does nothing
	public void Move(Maze m)
	{
	}
	
	/*for robot to get the new position based on direction given
	based on input of Position class given*/
	private int getPosition(Position lastPos, Position currentPos)
	{
		int x = current.getX() - last.getX();
		int y = current.getY() - last.getY();
		
		if (x > 0)
		{
			return EAST;
		}
		if (x < 0)
		{
			return WEST;
		}
		if (y > 0)
		{
			return SOUTH;
		}
		if (y < 0)
		{
			return NORTH;
		}
		else
		{
			System.err.println("I'm Stuck!");
			return -1;
		}
	}
}