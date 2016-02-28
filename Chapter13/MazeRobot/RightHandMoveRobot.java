//Chapter 13 - Project 13.1

public class RightHandMoveRobot extends Robot
{
	private int wall = 5;
	
	public RightHandMoveRobot (Maze m)
	{
		current = m.FindEntrance();
		future = m.FindEntrance();
	}
	
	public void Move (Maze m)
	{
		long timeTaken = System.currentTimeMillis();
		Position current = m.FindEntrance();
		
		//this sets the initial direction for the robot
		if (current.getX() == 1)
		{
			direction = SOUTH;
		}
		else if (current.getX() == 9)
		{
			direction = NORTH;
		}
		else if (current.getY() == 1)
		{
			direction = EAST;
		}
		else if (current.getY() == 9)
		{
			direction = WEST;
		}
		
		//while not end of map
		while (m.getPosition(current.getX(), current.getY()) != 3)
		{
			switch(direction)
			{
				case (NORTH) :
				{
					if (current.getDirection(m, EAST) == 1 || current.getDirection(m, EAST) == 3)
					{
						wall = 5;
						break;
					}
				}
				
				case (EAST) :
				{
					if (current.getDirection(m, SOUTH) == 1 || current.getDirection(m, SOUTH) == 3)
					{
						wall = 5;
						break;
					}
				}
				
				case (SOUTH) :
				{
					if (current.getDirection(m, WEST) == 1 || current.getDirection(m, WEST) == 3)
					{
						wall = 5;
						break;
					}
				}
				
				case (WEST) :
				{
					if (current.getDirection(m, NORTH) == 1 || current.getDirection(m, NORTH) == 3)
					{
						wall = 5;
						break;
					}
				}
			}
			
			//sets the position of the wall relative to robot's position
			/*
			while (wall == 5) //sets the position of the wall relative to robot's position
                                switch (direction)
                                {
                                case (NORTH):if (m.getPosition(current.getX()+1, current.getY()) == 2) wall = EAST;else {current.setModify(1, 0);break;}
                                case (EAST):if (m.getPosition(current.getX(), current.getY()+1) == 2) wall = SOUTH;else {current.setModify(0, 1);break;}
                                case (SOUTH):if (m.getPosition(current.getX()-1, current.getY()) == 2) wall = WEST;else {current.setModify(-1, 0);break;}
                                case (WEST):if (m.getPosition(current.getX(), current.getY()-1) == 2) wall = NORTH;else {current.setModify(0, -1);break;}
                                default:System.err.println("HERE BE DRAGONS"); System.exit(-1);//self terminates if robot is looking a wrong way
                                }
			
			
			*/
			while (wall == 5)
			{
				switch(direction)
				{
					case (NORTH) : 
					{
						if (m.getPosition(current.getX()+1, current.getY()) == 2)
						{
							wall = EAST;
							//break;
						}
						else
						{
							current.setModify(1,0);
							break;
						}
					}

					case (EAST) :
					{
						if (m.getPosition(current.getX(), current.getY()+1) == 2)
						{
							wall = SOUTH;
							//break;
						}
						else
						{
							current.setModify(0,1);
							break;
						}					
					}
					
					case (SOUTH) :
					{
						if (m.getPosition(current.getX()-1, current.getY()) == 2)
						{
							wall = WEST;
							//break;
						}
						else
						{
							current.setModify(-1,0);
							break;
						}					
					}
					
					case (WEST) :
					{
						if (m.getPosition(current.getX(), current.getY()-1) == 2)
						{
							wall = NORTH;
							//break;
						}
						else
						{
							current.setModify(0,-1);
							break;
						}
					}
					
					//self terminates if robot is looking a wrong way
					default :
			
						System.err.println("HERE BE DRAGONS");
						System.out.print(current.getX() + " " + current.getY());   //these are location debuggers      
						System.exit(-1);
						break;				
				}	
				        
			}
			
			switch(wall)
			{
				case (NORTH) :
				{
					if((current.getDirection(m, WEST) == 1 || current.getDirection(m, WEST) == 3))
					{
						current.setModify(-1,0);
						direction = WEST;
						break;
					}
					else if (current.getDirection(m, WEST) == 2 || current.getDirection(m, WEST) == 0)
					{
						//move towards 3, subtract from the x value
						wall = WEST;
						direction = SOUTH;
						break;
					}
				}

				case (EAST) :
				{
					if ((current.getDirection(m, NORTH) == 1 || current.getDirection(m, NORTH) == 3))
					{
						current.setModify(0,-1);
						direction = NORTH;
						break;
					}
					else if (current.getDirection(m, NORTH) == 2 || current.getDirection(m, NORTH) == 0)
					{
						wall = NORTH;
						direction = WEST;
						break;
					}
				}
				
				case (SOUTH) :
				{
					if ((current.getDirection(m, EAST) == 1|| current.getDirection(m, EAST) == 3))
					{
						current.setModify(1,0);
						direction = EAST;
						break;
					}
					else if (current.getDirection(m, EAST) == 2 || current.getDirection(m, EAST) == 3)
					{
						wall = EAST;
						direction = NORTH;
						break;
					}
				}
				
				case (WEST) :
				{
					if ((current.getDirection(m, SOUTH) == 1 || current.getDirection(m, SOUTH) == 3))
					{
						current.setModify(0,1);
						wall = SOUTH;
						break;
					}
					else if (current.getDirection(m, SOUTH) == 2 || current.getDirection(m, SOUTH) == 3)
					{
						wall = SOUTH;
						direction = EAST;
						break;
					}
				}
			}
		}
		
		System.out.println("\nRight Hand Robot has exited the maze");
		System.out.println("Took Right Hand Robot " + ((System.currentTimeMillis() - timeTaken) / 1000) + " Seconds!");
	}

	private void updateDirection()
	{
		direction = getPosition(last, current);
	}
	
	private int getPosition(Position lastPos, Position currentPos)
	{
		int x = currentPos.getX() - lastPos.getX();
		int y = currentPos.getY() - lastPos.getY();
		
		if (x > 0)
		{
			return EAST;
		}
		else if (x < 0)
		{
			return WEST;
		}
		else if (y > 0)
		{
			return SOUTH;
		}
		else if (y < 0)
		{
			return NORTH;
		}
		else
		System.err.println("I'm Stuck!");
		return -1;// both positions are the same
	}
}


























