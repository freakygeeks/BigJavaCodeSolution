public class MazeTester
{
	public static void main (String[] args)
	{
		char[][] m = {
					{'*', ' ', '*', '*', '*', '*', '*', '*', '*'}, 
					{'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
					{'*', ' ', '*', '*', '*', '*', '*', ' ', '*'}, 
					{'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'}, 
					{'*', ' ', '*', ' ', '*', '*', '*', ' ', '*'}, 
					{'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'}, 
					{'*', '*', '*', ' ', '*', ' ', '*', '*', '*'}, 
					{'*', ' ', ' ', '*', ' ', ' ', '*', ' ', '*'}, 
					{'*', '*', '*', '*', '*', '*', '*', ' ', '*'}
					};
					
		Maze maze = new Maze(m);
		System.out.println(maze.escape(4, 3));
		System.out.println("Expected : true");
		System.out.println(maze.escape(5, 5));
		System.out.println("Expected : false");
	}
}