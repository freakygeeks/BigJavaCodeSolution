/**
 * A 3 x 3 tic-tac-toe board. c02228561 Anh Le
 */
public class TicTacToe 
{

    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    /**
     * Constructs an empty board.
     */
    public TicTacToe()
    {
        board = new String[ROWS][COLUMNS];//first number is for row = paksi-X, second number is for column y = paksi-Y
        // Fill with spaces
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                board[i][j] = " ";
            }
        }
    }

    /**
     * Sets a field in the board. The field must be unoccupied.
     *
     * @param i the row index
     * @param j the column index
     * @param player the player ("x" or "o")
     * @return true if player's move is set
     */
    public boolean set(int i, int j, String player) 
    {
        if (board[i][j].equals(" ")) 
        {
            board[i][j] = player;
            return true;
        }
        return false;
    }

    /**
     * Creates a string representation of the board, such as |x o| | x | | o|
     * @return the string representation
     */
    public String toString() 
    {
        String r = "";
        for (int i = 0; i < ROWS; i++) 
        {
            r = r + "| "; //"|" is used for left separator
            for (int j = 0; j < COLUMNS; j++) 
            {
                r = r + board[i][j] + " ";
            }
            r = r + "|\n"; //"|" is used for right separator and "\n" is used for next line
        }
        return r;
    }
    
    /**
     * Checks if the current player wins
     * @param player the current player
     * @return true if the player wins
     */

    public boolean playerWins(String player) 
    {
        boolean hasWon = false;
        int count = 0;

        // Check for the same player on the same row
        for (int i = 0; i < ROWS; i++) //checking for total in row = 3
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if (player.equals(board[i][j])) 
                {
                    count++;
                }
            }
            
            // Player wins if count == 3
            if (count == 3) 
            {
                hasWon = true;
                break;
            }
            
            // Resets count before checking the next row
            count = 0;
        }
        
         // Check for the same player on the same column
        if (!hasWon)
        {
            for (int j = 0; j < COLUMNS; j++) //checking for total in column = 3
            {
                for (int i = 0; i < ROWS; i++) 
                {
                    if (player.equals(board[i][j])) 
                    {
                        count++;
                    }
                }
            
                // Player wins if count == 3
                if (count == 3) 
                {
                    hasWon = true;
                    break;
                }

                // Resets count before checking the next column
                count = 0;
            }
        }        
      
        // Check for same player on the diagonal running from the top-left corner to the bottom-right corner
        if (!hasWon)
        {
            for (int i = 0; i < ROWS; i++) 
            {            
                if (player.equals(board[i][i])) //number for row and column must be same (0,0), (1,1) and (2,2)
                {
                    count++;
                }

                // Player wins if count == 3
                if (count == 3) 
                {
                    hasWon = true;
                    break;
                }                       
            }
            // Resets count before next check
            count = 0;
        }
        
        
        // Check for same player on the diagonal running from the top-right corner to the bottom-left corner
        if (!hasWon)
        {
            int diagonal = 2;
            for (int i = 0; i < ROWS; i++) 
            {                                 
                if (player.equals(board[i][diagonal])) 
                {
                    count++;
                }
                        
                // Player wins if count == 3
                if (count == 3) 
                {
                    hasWon = true;
                    break;
                }  
                diagonal--;//number for column start with 2 and must be decrement to get (0,2), (1,1) and (2,0)
            }            
        }       
        
        // Returns true if the player wins
        return hasWon;
    }
}
