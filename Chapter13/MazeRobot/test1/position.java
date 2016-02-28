

public class position
{
        private int x = 0, y = 0;
        
        public position(int a, int b)
        {
                x = a;
                y = b;
        }
        public position() 
        {
                //it's the default constructor. i figured we would want one so we can set stuff.
                //we can get rid of it later when we know what we're doing
                x = 0;
                y = 0;
                //this space should be impossible to start from, as there would be 2 walls and 2 out-of-bounds areas surrounding it
        }
        public void modify(int a, int b)
        {
                x += a;
                y += b;
        }
        
        public int getx()
        {
                return x;
        }
        public int gety()
        {
                return y;
        }
        public void setPosition(int a, int b)
        {
                x = a;
                y = b;
        }
        public int check(Maze m, int direction)
        {
                switch (direction)
                {
                case 0: return m.CheckPos(x, y-1);
                case 1: return m.CheckPos(x+1, y);
                case 2: return m.CheckPos(x, y+1);
                case 3: return m.CheckPos(x-1, y);
                default:System.err.println("Something bad happened trying to check the next move!");System.exit(-83);break;
                }
                return -2; //you really shouldent be able to get here
        }
}