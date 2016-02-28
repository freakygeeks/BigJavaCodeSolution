//Chapter 18 - Exercise P18.13

public class DiskMoverTester
{
	public static void main (String[] args)
	{
		int n = 3;
		DiskMover mover = new DiskMover(1, 3, n);
		while (mover.hasMoreMove())
		{
			System.out.println("mover.nextMove()");
			mover.nextMove();
		}
		
			System.out.println("mover.hasMoreMove()");
			mover.hasMoreMove();
		
		/*
		System.out.println(mover.nextMove());
		System.out.println("Expected : Mover disk from peg 1 to peg 3");
		
		System.out.println(mover.nextMove());
		System.out.println("Expected: Move disk from peg 1 to peg 2");

		System.out.println(mover.nextMove());
		System.out.println("Expected: Move disk from peg 3 to peg 2");

		System.out.println(mover.nextMove());
		System.out.println("Expected: Move disk from peg 1 to peg 3");

		System.out.println(mover.nextMove());
		System.out.println("Expected: Move disk from peg 2 to peg 1");

		System.out.println(mover.nextMove());
		System.out.println("Expected: Move disk from peg 2 to peg 3");

		System.out.println(mover.nextMove());
		System.out.println("Expected: Move disk from peg 1 to peg 3");

		System.out.println(mover.hasMoreMove());
		System.out.println("Expected: false");
		*/
	}
}