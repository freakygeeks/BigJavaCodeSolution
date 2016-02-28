//Chapter11 - Project 11.2

public class GamePlayer
{	
	private GameInterface game1;
	private GameInterface game2;
	
	public GamePlayer()
	{
	game1 = new PlayerOfNim();
	game2 = new TicTacToeWin();
	}
	
	public void play()
	{
	if (game1.isValidMove())//(String move))
		{
		game1.executeMove();
		}
	if (game2.isValidMove())//(String move))
		{
		game2.executeMove();
		}
	}
}
