//Chapter11 - Project 11.2

import java.util.Scanner;

public class TicTacToeWin implements GameInterface
{	
	private static final int ROW = 3;
	private static final int COLUMN = 3;
	private String[][] board; //declare two dimensional array for String type with 3x3 length
	private boolean win;
	
	Scanner in = new Scanner(System.in);
	String playerGame = "x";
	int totalMove = 0; //total move made by both of the players
	boolean done = false; //assign done as "false" boolean

	public TicTacToeWin() //create an empty board
	{
	board = new String[ROW][COLUMN]; //initiate empty board with ROW for paksi-X and COLUMN for paksi-Y
	for (int i = 0; i < ROW; i++) //declare loop for ROW array
		{
		for (int j = 0; j < COLUMN; j++) //declare loop for COLUMN array
			{
			board[i][j] = " "; //create board with empty string
			}
		}
	}
	
	public boolean setPlayer (int i, int j, String player) //check a field for player
	{
	if (board[i][j].equals(" ")) //if board is empty
		{
		board[i][j] = player; //set player with the value enter for ROW and COLUMN for that field
		return true; //field is true if empty
		}	
	return false; //field is false if occupied
	}

	public boolean playerWin (String player) //check a player win
	{
	win = false; //assign win as "false" boolean
	int count = 0;
	
	for (int i = 0; i < ROW; i++) //check if a player has all the same value in one row
		{
		for (int j = 0; j < COLUMN; j++)
			{
			if (player.equals(board[i][j])) //if the row have the same value 
				{
				count++; //add all the count for value in row
				}
			}
			
		if (count == 3) //total count of the same value should be 3
			{
			win = true; //the player win
			break;
			}
			
		count = 0; //reset count
		}

	if (!win) //as long as !win is true, continue entering the loop since !win means "the opposite of "win"
	//the statement "win == false" or "!win" compares done to false and will be true if the value of "win" is false (win = false) and false if the value of "win" is true (win = true)
		{
		for (int j = 0; j < COLUMN; j++) //check if a player has all the same value in one column
			{
			for (int i = 0; i < ROW; i++)
				{
				if (player.equals(board[i][j])) //if the column have the same value
					{
					count++; //add all the count for value in column
					}
				}
				
			if (count == 3) //total count of the same value in column should be 3
				{
				win = true; //the player win
				break;				
				}
				
			count = 0; //reset count
			}
		}

	if (!win) //as long as !win is true, continue entering the loop since !win means "the opposite of "win"
	//the statement "win == false" or "!win" compares done to false and will be true if the value of "win" is false (win = false) and false if the value of "win" is true (win = true)
		{
		for (int i = 0; i < ROW; i ++) // check if a player has all the same value in diagonal from top-left conner to bottom-right corner
			{
			if (player.equals(board[i][i])) //if this diagonal from top-left conner to bottom-right corner have the same value, number for row and column must be same (0,0), (1,1) and (2,2)
				{
				count++; //add all the count for value in diagonal
				}
				
			if (count == 3) //total count of the same value in diagonal should be 3
				{
				win = true; //the player win
				break;
				}
			}
		count = 0; //reset count
		}		
		
	if (!win) //as long as !win is true, continue entering the loop since !win means "the opposite of "win"
	//the statement "win == false" or "!win" compares done to false and will be true if the value of "win" is false (win = false) and false if the value of "win" is true (win = true)
		{
		int diagonal = 2; //define the start of diagonal value
		for (int i = 0; i < ROW; i++) //check if a player has all the same value in diagonal from top-right corner to the bottom-left corner
			{
			if (player.equals(board[i][diagonal])) //if this diagonal from top-right corner to the bottom-left corner have the same value, number for column start with 2 and must be decrement to get (0,2), (1,1) and (2,0)
				{
				count++; //add all the count for value in diagonal
				}
				
			if (count == 3) //total count of the same value in diagonal should be 3
				{
				win = true; //the player win
				break;
				}
				
			diagonal--; //decrement the value of diagonal from top-right corner to the bottom-left corner
			}
		count = 0; //reset count
		}
		
	return win; //return boolean win = true if any player has win the game
	}
	
	public boolean isValidMove ()//(String move)
	{
	if (win == true)
		{
		return false;
		}
	return true;
	}
	
	public void executeMove()
	{
	while (!done) //as long as !done is true, continue entering the loop since !done means "the opposite of "done"
	//the statement "done == false" or "!done" compares done to false and will be true if the value of "done" is false (done = false) and false if the value of "done" is true (done = true)
		{
		System.out.println("Row for " + playerGame + " : "); //input to enter a row value
		int row = in.nextInt();
		
		while (row < 0 || row > 2) //checking input for row value should be between 0 and 2
			{
			System.out.println("Row value should be between 0 until 2 only. Please choose again");
			System.out.print("Row for " + playerGame + " : ");
			row = in.nextInt();
			}
			
		System.out.println("Column for " + playerGame + " : "); //input to enter a column value
		int column = in.nextInt();
		
		while (column < 0 || column > 2) //checking input for column value should be between 0 and 2
			{
			System.out.println("Column value should be between 0 until 2 only. Please choose again");
			System.out.print("Column for " + playerGame + " : ");
			column = in.nextInt();
			}
			
		if (!setPlayer(row,column,playerGame)) //check if a row and column has been fill by a player
			{
			System.out.println("Position is occupied. Please try again");
			continue; //if yes, then repeat the process again
			}
			
		totalMove++; //add value of all move made by player
		
		if (playerWin(playerGame)) //check if a player field is continuous for row or column or diagonal
			{
			done = true; //if yes, then that player is the winner
			System.out.println("\nPlayer " + playerGame + " won the game\n");
			System.out.println("################################################################\n");
			}
		else //if no player win, then take turn between player "x" and "o"
			{
			if (playerGame.equals("x"))
				{
				playerGame = "o";
				}
			else
				{
				playerGame = "x";
				}
			}
			
		if (totalMove == 9 && !playerWin(playerGame))
			{
			System.out.println ("\nIt\'s a draw\n");
			System.out.println("################################################################\n");
			done = true;
			}
		}	
	}
}