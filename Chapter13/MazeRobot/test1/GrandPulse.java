

public class GrandPulse {
        
        public static void main(String[] args)
        {
                Maze Findme = new Maze();
                MemoryRobot Brain = new MemoryRobot(Findme);
                Brain.Move(Findme);
                RightHandMoveRobot Touma = new RightHandMoveRobot(Findme);
                Touma.Move(Findme);
                RandomRobot Blind = new RandomRobot(Findme);
                Blind.Move(Findme);
                System.out.println("\n\nAll robots have successfully navigated the maze. \nThank you for using the Aperture Science Enrichment Center Room Navigation System.\nGoodbye");
        }

}