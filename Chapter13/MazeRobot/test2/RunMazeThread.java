import javax.swing.JOptionPane;

public class RunMazeThread extends Thread {

	public long delay;
	private Maze maze;
	private int numMoves;

	public RunMazeThread(Maze setMaze, long setDelay) {
		super();
		maze = setMaze;
		delay = setDelay;
		numMoves = 0;
	}

	public void run() {
		long start = 0;
		long diff = 0;

		while (!maze.rob.isFinished()) {
			try {
				start = System.currentTimeMillis();
				maze.updateMaze();
				numMoves++;
				diff = System.currentTimeMillis() - start;
				diff = delay - diff;
				if (diff < 0)
					diff = 0;
				Thread.sleep(diff);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				System.err.println(e.getMessage());
			}
		}
		String s = "Robot has finished and has escaped the maze in " + numMoves
				+ " moves.";
		System.out.println(s);
		JOptionPane.showMessageDialog(maze, s, "About",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
