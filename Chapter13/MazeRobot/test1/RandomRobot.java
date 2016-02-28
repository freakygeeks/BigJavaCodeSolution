

import java.util.Random;

public class RandomRobot extends robot {

        
        public RandomRobot(Maze m)
        {
                currentPosition = m.findb();
                futurePosition = m.findb();
                
        }
        
        int x = 0, y = 0;
        //private Map<> m; 
        public void Move(Maze m)
        {
                Random pie = new Random();
                int thatway, Moves = 0;         
                long signout = System.currentTimeMillis();

                while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
                {
                        thatway = pie.nextInt(4);
                        
                        switch(thatway)
                        {
                                case 0:
                                        futurePosition.modify(1, 0);
                                        if(m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 1 || m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 3)
                                                currentPosition.modify(1, 0);
                                        else
                                                futurePosition.modify(-1, 0);
                                        break;
                                case 1:
                                        futurePosition.modify(0, 1);
                                        if(m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 1 || m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 3)
                                                currentPosition.modify(0, 1);
                                        else
                                                futurePosition.modify(0, -1);
                                        break;
                                case 2:
                                        futurePosition.modify(-1, 0);
                                        if(m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 1 || m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 3)
                                                currentPosition.modify(-1, 0);
                                        else
                                                futurePosition.modify(1, 0);
                                        break;
                                case 3:
                                        futurePosition.modify(0, -1);
                                        if(m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 1 || m.CheckPos(futurePosition.getx(), futurePosition.gety()) == 3)
                                                currentPosition.modify(0, -1);
                                        else
                                                futurePosition.modify(0, 1);
                                        break;
                                default:
                                        System.out.println("Random You have failed me for the last time... AGAIN!");
                                        System.exit(1);
                                        break;
                                
                        }
                        Moves++;
                }
                System.out.println("\nRandom Robot has exited the maze");
                System.out.println("Took Random Robot " + ((System.currentTimeMillis() - signout) / 1000 + "Seconds!"));
                System.out.println("Took " + Moves + " Moves");
        }
}