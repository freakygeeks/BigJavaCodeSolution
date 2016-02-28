//Chapter 13 - Project 13.1

public class MazeTester
{
	public static void main (String[] args)
	{
		Maze FindMe = new Maze();
		
		RandomRobot Blind = new RandomRobot(FindMe);
		Blind.Move(FindMe);
		System.out.println("Random Robot have successfully navigated the maze.\n");
		
		MemoryRobot Brain = new MemoryRobot(FindMe);
		Brain.Move(FindMe);
		System.out.println("Memory Robot have successfully navigated the maze.\n");
		
		RightHandMoveRobot Hand = new RightHandMoveRobot(FindMe);
		Hand.Move(FindMe);
		System.out.println("Right Hand Move Robot have successfully navigated the maze.\n");
	}
}