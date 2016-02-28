//Chapter8 - Exercise P8.16

import java.util.Scanner;

public class TicTacToeWinViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	TicTacToeWin game = new TicTacToeWin();
	String player = "x";
	int totalMove = 0; //total move made by both of the players
	boolean done = false; //assign done as "false" boolean
	
	while (!done) //as long as !done is true, continue entering the loop since !done means "the opposite of "done"
	//the statement "done == false" or "!done" compares done to false and will be true if the value of "done" is false (done = false) and false if the value of "done" is true (done = true)
		{
		System.out.println("Row for " + player + " : "); //input to enter a row value
		int row = in.nextInt();
		
		while (row < 0 || row > 2) //checking input for row value should be between 0 and 2
			{
			System.out.println("Row value should be between 0 until 2 only. Please choose again");
			System.out.print("Row for " + player + " : ");
			row = in.nextInt();
			}
			
		System.out.println("Colum for " + player + " : "); //input to enter a column value
		int column = in.nextInt();
		
		while (column < 0 || column > 2) //checking input for column value should be between 0 and 2
			{
			System.out.println("Column value should be between 0 until 2 only. Please choose again");
			System.out.print("Column for " + player + " : ");
			column = in.nextInt();
			}
			
		if (!game.setPlayer(row,column,player)) //check if a row and column has been fill by a player
			{
			System.out.println("Position is occupied. Please try again");
			continue; //if yes, then repeat the process again
			}
			
		totalMove++; //add value of all move made by player
		
		if (game.playerWin(player)) //check if a player field is continuous for row or column or diagonal
			{
			done = true; //if yes, then that player is the winner
			System.out.println("\nPlayer " + player + " won the game\n");
			}
		else //if no player win, then take turn between player "x" and "o"
			{
			if (player.equals("x"))
				{
				player = "o";
				}
			else
				{
				player = "x";
				}
			}
			
		if (totalMove == 9 && !game.playerWin(player))
			{
			System.out.println ("\nIt\'s a draw\n");
			done = true;
			}
		}	
	}
}