import java.util.Scanner;

/**
 * This program runs a TicTacToe game. It prompts the user to set positions on
 * the board and prints out the result. c02228561 Anh Le
 */
public class TicTacToeRunner {

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String player = "x";
        int totalMoves = 0; //total moves both players made
        TicTacToe game = new TicTacToe();
        boolean done = false; 
        while (!done) 
        {
            // System.out.println(game.toString()); 
            
            // Prompts player to choose a row
            System.out.print("Row for " + player + " : ");
            int row = in.nextInt();
            
            // Checks if row is valid
            while (row < 0 || row > 2) 
            {
                System.out.println("Row should be from 0 to 2. Please try again");
                System.out.print("Row for " + player + " : ");
                row = in.nextInt();
            }
            
            // Prompts player to choose a column
            System.out.print("Column for " + player + ": ");
            int column = in.nextInt();
            
            // Checks if column is valid
            while (column < 0 || column > 2) 
            {
                System.out.println("Column should be from 0 to 2. Please try again");
                System.out.print("Column for " + player + " : ");
                column = in.nextInt();
            }
            
            // Sets player's move to board
            if (!game.set(row, column, player))
            {
                System.out.println("Position is occupied. Please try again");
                continue;
            }
            
            totalMoves++; // Increment total moves
            if (game.playerWins(player)) 
            {
                done = true;
                System.out.println("\nPlayer " + player + " won the game\n");
            } 
            else //to take turn between two different player for each turn
            {
                if (player.equals("x")) 
                {
                    player = "o"; //will be the second turn, change the string "x" to "o" for player input
                } 
                else 
                {
                    player = "x";//will be the first turn 
                }
            }

            if (totalMoves == 9 && !game.playerWins(player)) 
            {
                System.out.println("\nIt\'s a draw!\n");
                done = true;
            }

            // Prints the board
            System.out.println(game.toString());                         
        }
    }
}
