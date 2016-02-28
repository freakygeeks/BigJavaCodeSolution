
public class robot 
{
        protected position currentPosition;
        protected position lastPosition;
        protected position futurePosition;
        int direction = 0; 
        public static final int DIR_NORTH = 0;
        public static final int DIR_SOUTH = 2;
        public static final int DIR_EAST = 1;
        public static final int DIR_WEST = 3;

        
        public void Move( Maze m )
        {
                //Does Nothing
        }
        
        /*protected position getStart(position begin) // what do we put here?
        {
                position start = new position(map.position);
                
                //returns a position that is the entrance to the maze
                
                //seeing as the entrances are on the sides of the maze... this code will
                //forcefully set the initial direction of the robot. direction is stored
                //here after all
                
                if (start.getx() == 0)
                         direction = DIR_SOUTH;
                else if (start.getx() == 8)
                        direction = DIR_NORTH;
                else if (start.gety() == 0)
                        direction = DIR_EAST;
                else if (start.gety() == 8)
                        direction = DIR_WEST;
                
                return start;
        } */
        
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
        

        
// last position = new position
        //new position = move(direction)
        //direction = getdirection(last position new position)
}