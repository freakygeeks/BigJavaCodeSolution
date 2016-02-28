

public class RightHandMoveRobot extends robot 
{
        private int wall = 5;
        public RightHandMoveRobot(Maze m)
        {
                currentPosition = m.findb();
                futurePosition = m.findb();
        }
        public void Move(Maze m)
        {
                long signout = System.currentTimeMillis();

                position currentPosition = m.findb();
                if (currentPosition.getx() == 1) //this sets the initial direction for the robot
                         direction = DIR_SOUTH;
                else if (currentPosition.getx() == 9)
                        direction = DIR_NORTH;
                else if (currentPosition.gety() == 1)
                        direction = DIR_EAST;
                else if (currentPosition.gety() == 9)
                        direction = DIR_WEST;

                while (m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)//while not end of map
                {
                        switch (direction)
                        {
                        case (DIR_NORTH):
                        {
                                if (currentPosition.check(m, DIR_EAST) == 1 || currentPosition.check(m, DIR_EAST) == 3)
                                {
                                        wall = 5;
                                        break;
                                }
                        }
                        case (DIR_EAST):
                        {
                                if (currentPosition.check(m, DIR_SOUTH) == 1 || currentPosition.check(m, DIR_SOUTH) == 3)
                                {
                                        wall = 5;
                                        break;
                                }
                        }
                        case (DIR_SOUTH):
                        {
                                if (currentPosition.check(m, DIR_WEST) == 1 || currentPosition.check(m, DIR_WEST) == 3)
                                {
                                        wall = 5;
                                        break;
                                }
                        }
                        case (DIR_WEST):
                        {
                                if (currentPosition.check(m, DIR_NORTH) == 1 || currentPosition.check(m, DIR_NORTH) == 3)
                                {
                                        wall = 5;
                                        break;
                                }
                        }
                        }
                        while (wall == 5) //sets the position of the wall relative to robot's position
                                switch (direction)
                                {
                                case (DIR_NORTH):if (m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 2) wall = DIR_EAST;else currentPosition.modify(1, 0);break;
                                case (DIR_EAST):if (m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 2) wall = DIR_SOUTH;else currentPosition.modify(0, 1);break;
                                case (DIR_SOUTH):if (m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 2) wall = DIR_WEST;else currentPosition.modify(-1, 0);break;
                                case (DIR_WEST):if (m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 2) wall = DIR_NORTH;else currentPosition.modify(0, -1);break;
                                default:System.err.println("HERE BE DRAGONS"); System.exit(-82);//self terminates if robot is looking a wrong way
                                }
                        //System.out.print(currentPosition.getx());        //these are location debuggers
                        //System.out.println(" " + currentPosition.gety());

                        switch (wall)
                        {
                        case (DIR_NORTH):
                                if ((currentPosition.check(m, DIR_WEST) == 1 || currentPosition.check(m, DIR_WEST) == 3))
                                        {
                                        currentPosition.modify(-1, 0);
                                        direction = DIR_WEST;
                                        break;
                                        }
                                else if (currentPosition.check(m, DIR_WEST) == 2 || currentPosition.check(m, DIR_WEST) == 0) 
                                        {
                                        wall = DIR_WEST;
                                        direction = DIR_SOUTH;
                                        break;    //move towards 3, subtract from the x value
                                        }
                        case (DIR_EAST):
                                if ((currentPosition.check(m, DIR_NORTH) == 1 || currentPosition.check(m, DIR_NORTH) == 3))
                                        {
                                        currentPosition.modify(0, -1);
                                        direction = DIR_NORTH;
                                        break;
                                        }
                                else if (currentPosition.check(m, DIR_NORTH) == 2 || currentPosition.check(m, DIR_NORTH) == 0)
                                        {
                                        wall = DIR_NORTH;
                                        direction = DIR_WEST;
                                        break;
                                        }
                        case (DIR_SOUTH):
                                if ((currentPosition.check(m, DIR_EAST) == 1 || currentPosition.check(m, DIR_EAST) == 3))
                                        {
                                        currentPosition.modify(1, 0);
                                        direction = DIR_EAST;
                                        break;
                                        }
                                else if (currentPosition.check(m, DIR_EAST) == 2 || currentPosition.check(m, DIR_EAST) == 0)
                                        {
                                        wall = DIR_EAST;
                                        direction = DIR_NORTH;
                                        break;
                                        }
                        case (DIR_WEST):
                                if ((currentPosition.check(m, DIR_SOUTH) == 1 || currentPosition.check(m, DIR_SOUTH) == 3))
                                        {
                                        currentPosition.modify(0, 1);
                                        wall = DIR_SOUTH;
                                        break;
                                        }
                                else if (currentPosition.check(m, DIR_SOUTH) == 2 || currentPosition.check(m, DIR_SOUTH) == 0)
                                        {
                                         wall = DIR_SOUTH;
                                         direction = DIR_EAST;
                                         break;
                                        }
                        }
                }
                System.out.println("\nRight Hand Robot has exited the maze");
                System.out.println("Took Right Hand Robot " + ((System.currentTimeMillis() - signout) / 1000 + " Seconds!")); 
				System.out.print(currentPosition.getx() + " " + currentPosition.gety());   //these are location debuggers   
		}
        
        @SuppressWarnings("unused")
        private void updateDirection()
        {
                direction = getDirection( lastPosition, currentPosition );
        }
        private int getDirection (position lasPos,position curPos)
        {
                int xdif = curPos.getx() - lasPos.getx();
                int ydif = curPos.gety() - lasPos.gety();
                if (xdif > 0)
                        return DIR_EAST;
                else if(xdif < 0)
                        return DIR_WEST;
                else if(ydif > 0)
                        return DIR_SOUTH;
                else if(ydif < 0)
                        return DIR_NORTH;
                System.err.println("I'm Stuck!");
                return -1; // both positions are the same
        }
}
