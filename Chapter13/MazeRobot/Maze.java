//Chapter 13 - Project 13.1

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze
{
	private char[][] ver = new char[11][11];
	public static final int ENTRANCE = 0;
	public static final int SPACE = 1;
	public static final int WALL = 2;
	public static final int EXIT = 3;

	//get the input file of maze to be read
	public Maze() 
	{
		FileReader txt = null;
		Scanner file = null;
		
		try
		{
			txt = new FileReader("input.txt");
			file = new Scanner(txt);
			ReadMaze(txt);
		}
		catch (IOException e)
		{
		}
		
		finally
		{
			if (file != null)
			{
				file.close();
			}
			
			if (txt != null)
			{
				try 
				{
					txt.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	//read the input file of maze that has been loaded in constructor
	private void ReadMaze(FileReader file) throws IOException
	{
		int i;
		int j;
		
		StringBuilder sb = new StringBuilder();
		String currentLine = null;
		BufferedReader br = new BufferedReader(file);
		
		while ((currentLine = br.readLine()) != null)
		{
			sb.append(currentLine);
		}
		
		String data = sb.toString();
		System.out.println("Data : " );
		
		for(i = 0; i < 11; i++)
		{
			for(j = 0; j < 11; j++)
			{
				ver[i][j] = data.charAt(i*11+j);
				System.out.print(ver[i][j]);
			}
			System.out.println();
		}
	}
	
	//get the start of maze position
	public Position FindEntrance()
	{
		int i;
		int j;
		
		Position entrance;
		
		for (i = 0; i < 11; i++)
		{
			for (j = 0; j < 11; j++)
			{
				if(ver[i][j] == 'o')
				{
					entrance = new Position(i, j);
					return entrance;
				}
			}
		}
		
		System.err.println("No entrance found. Some maze you got here, buddy.");
		System.exit(1);
		return(entrance = new Position());
	}
	
	//get the end of maze position
	public Position FindExit()
	{
		int i;
		int j;
		
		Position exit;
		
		for (i = 0; i < 11; i++)
		{
			for (j = 0; j < 11; j++)
			{
				if(ver[i][j] == 'x')
				{
					exit = new Position(i,j);
					return exit;
				}
			}
		}
		
		System.err.println("No exit found. Now you're just evil.");
		System.exit(1);
		return (exit = new Position());
	}
	
	/*check the position either start, end, wall or out of bounds
	and then change the direction*/
	public int getPosition(int x, int y)
	{
		if (x < 0 || x > 10 || y < 0 || y > 10)
		{
			System.err.println("Out of bounds. You've fallen into Valhala.");
			return -1;
		}
		
		if (ver[y][x] == 'o')
		{
			return ENTRANCE;
		}
		else if (ver[y][x] == ' ')
		{
			return SPACE;
		}
		else if (ver[y][x] == '*')
		{
			return WALL;
		}
		else if (ver[y][x] == 'x')
		{
			return EXIT;
		}
		else
		{
			System.err.println("Not a valid character. Get that guy outta here!");
			return -2;
		}
	}
}




















































