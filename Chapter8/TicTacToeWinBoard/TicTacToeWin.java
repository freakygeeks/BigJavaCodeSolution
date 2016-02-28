//Chapter8 - Exercise P8.17
//http://anhlqn.blogspot.com/2013/04/gwc-computer-science-g153-java.html

public class TicTacToeWin
{	
	private static final int ROW = 3;
	private static final int COLUMN = 3;
	private String[][] board; //declare two dimensional array for String type with 3x3 length

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
	
	public String toString() //create representation of player in a board
	{
	String rc = ""; // initialize an empty field
	for (int i = 0; i < ROW; i++)
		{
		rc = rc + "| "; //used | for left separator in ROW
		for (int j = 0; j < COLUMN; j++)
			{
			rc = rc + board[i][j] + " "; //add the empty board field with player identification and space one
			}
		rc = rc + "|\n"; //used | for right separator in ROW and also \n for newline in ROW
		}
	return rc; // return the value to board
	}

	public boolean playerWin (String player) //check a player win
	{
	boolean win = false; //assign win as "false" boolean
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
}