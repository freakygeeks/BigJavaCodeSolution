//Chapter11 - Project 11.2

public class GameOfNim
{
	public static void main (String[] args)
	{
	System.out.println();
	System.out.println("******************RULES OF THE NIM GAME***********************");
	System.out.println("The number of marbles in the initial pile will be random amount between 10 and 100.");
	System.out.println("Each player must choose between 1 and half of the remaining pile of marbles to remove.");
	System.out.println("The player stuck with the last marble loses the game."); 
	System.out.println("The computer will randomly be placed into simple or smart mode randomly.");
	System.out.println("The player who goes first will also be chosen at random.");
	System.out.println("*************************************************************");
	
	
	PileOfNim calc = new PileOfNim();
	int num = calc.getPileRandom();
	int type = 0;
	int firstplayer = 0;
	int secondplayer = 0;

	//generate random pile between 10 to 100
	System.out.println("Initial size of pile between 10 to 100 is generating..");
	System.out.println("Initial marble in a pile is : " + num);
	
	//computer smart, computer stupid or human turn first
	if (calc.getTurnRandom() == 0 && calc.getModeRandom() == 0)
		{
		type = 1;//"Computer Mode : Smart
		/*computer smart will be firstPlayer and human is secondPlayer*/
		firstplayer = 3;
		secondplayer = 1;
		}
	else if (calc.getTurnRandom() == 0 && calc.getModeRandom() == 1)
		{
		type = 2;//Computer Mode : Stupid
		/*computer stupid will be firstPlayer and human is secondPlayer*/
		firstplayer = 3;
		secondplayer = 2;
		}
	else 
		{
		type = 3;//Human mode
		/*human will be firstPlayer and computer is secondPlayer*/
		if (calc.getModeRandom() == 0)
			{
			firstplayer = 1;
			secondplayer = 3;
			}
		else if (calc.getModeRandom() == 1)
			{
			firstplayer = 2;
			secondplayer = 3;
			}
		else
			{
			System.out.println("invalid stage");
			}
		}
	
	PlayerOfNim play = new PlayerOfNim();
	play.getPlaying(num, type);
	System.out.println("Balance marble in a pile : " + play.getMarble());
	int balanceMarble = play.getMarble();
		
	PlayerOfNim play1 = new PlayerOfNim();
	PlayerOfNim play2 = new PlayerOfNim();
		
	while (balanceMarble > 0)
		
		{
		play1.getPlaying(balanceMarble, firstplayer);
		int balanceMarble1 = play1.getMarble();
		balanceMarble = balanceMarble1;
		System.out.println("Balance marble in a pile : " + balanceMarble);
		
		if(balanceMarble == 1)
			{
			System.out.println("Game over. Player 1 win!");
			break;
			}
	
		play2.getPlaying(balanceMarble, secondplayer);
		int balanceMarble2 = play2.getMarble();
		balanceMarble = balanceMarble2;
		System.out.println("Balance marble in a pile : " + balanceMarble);
		
		if(balanceMarble == 1)
			{
			System.out.println("Game over. Player 2 win!");
			break;
			}

		}
	}	
}
