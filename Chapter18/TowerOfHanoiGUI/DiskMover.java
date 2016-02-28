//Chapter 18 - Project 18.2
//http://en.wikipedia.org/wiki/Tower_of_Hanoi

public class DiskMover
{
	private int source;
	private int target;
	private int disk;
	private DiskMover mover;
	private int state;
	private static final int BEFORE_LARGEST = 1;
	private static final int LARGEST = 2;
	private static final int AFTER_LARGEST = 3;
	private static final int DONE = 4;

	public DiskMover (int src, int dest, int dsk)
	{
		source = src;
		target = dest;
		disk = dsk;
		
		int other = 6 - source - target;
		if (disk > 1)
		{
			mover = new DiskMover (source, other, disk - 1);
			state = BEFORE_LARGEST;
		}
	}
	
	public boolean hasMoreMove()
	{
		return state != DONE;
	}
	
	public int[] nextMove()
	{
		if (disk == 1)
		{
			state = DONE;
			return new int[]{source, target};
		}
		
		if (state == LARGEST)
		{
			state = AFTER_LARGEST;
			int other = 6 - source - target;
			mover = new DiskMover(other, target, disk - 1);
			return new int[]{source, target};
		}
		
		int[] r = mover.nextMove();
		
		if (!mover.hasMoreMove())
		{
			if (state == BEFORE_LARGEST)
			{
				state = LARGEST;
			}
			
			else
			{
				state = DONE;
			}
		}
		
		return r;
	}
}

















