//Chapter 18 - Exercise P18.14

public class MazeTester
{
	public static void main (String[] args)
	{
		String[] m = {
						"* *******",
						"*     * *", 
						"* *******", 
						"* * *   *", 
						"* * *** *",
						"*   *   *",
						"*** * ***",
						"*     * *",
						"******* *",
					};
					
		Maze maze = new Maze(m);
		
		System.out.println("Result : " + maze.escape(3, 4));
		System.out.println("Expected true : Escaped!");
		System.out.println(maze);
		
		System.out.println("Result : " + maze.escape(5, 5));
		System.out.println("Expected false : Could not escaped!");
		System.out.println(maze);
		
	}
}