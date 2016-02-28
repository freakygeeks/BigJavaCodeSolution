//Chapter11 - Project 11.2

import java.util.Random;
import java.util.Scanner;

public class PlayerOfNim implements GameInterface
{
	public static final int COMPUTER = 0;
	public static final int HUMAN = 1;
	public static final int SMART = 0;
	public static final int STUPID = 1;	

	private Random gen;
	private int num;
	private int type;
	private int marble;
	private int balanceMarble;
	private boolean win;
	
	PileOfNim calc = new PileOfNim();
	int numGame = calc.getPileRandom();
	int typeGame = 0;
	int firstplayer = 0;
	int secondplayer = 0;
	
	Scanner in = new Scanner(System.in);
	
	PlayerOfNim()
	{
	gen = new Random();
	num = 0;
	type = 0;
	marble = 0;
	}
	
	public void getPlaying(int num, int type)
	{
	int smart = 0;
	int stupid = 0;
	int user;

	if (type == 1)
		{
		System.out.println("Computer turn : Smart mode");//computer start 1st, smart mode
			if (num > 63)
				{
				smart = num - 63;
				System.out.println(smart);
				marble = num - smart;
				}
			else if (num > 31)
				{
				smart = num - 31;
				System.out.println(smart);
				marble = num - smart;
				}
			else if (num > 15)
				{
				smart = num - 15;
				System.out.println(smart);
				marble = num - smart;
				}
			else if (num > 7)
				{
				smart = num - 7;
				System.out.println(smart);
				marble = num - smart;
				}
			else if (num > 3)
				{
				smart = num - 3;
				System.out.println(smart);
				marble = num - smart;
				}
			else
				{
				smart = gen.nextInt((num/2)+2);	
				while (smart == 0)
					{
					smart = in.nextInt();
					}					
				System.out.println(smart);				
				marble = num - smart;
				}
		}
	else if (type == 2)
		{
		System.out.println( "Computer turn : Stupid mode");//between 1 - n/2 for stupid mode
		stupid = gen.nextInt((num/2)+1);
		while (stupid == 0)
			{
			stupid = in.nextInt();
			}		
		System.out.println(stupid);
		marble = num - stupid;
		}
	else if (type == 3)
		{
		System.out.println("Human turn. Please choose between 1 until " + num/2);//human start 1st
		user = in.nextInt();//prompt input for human to key in 
		
		while (user <= 0 || user > num/2)
			{
			System.out.println("You must choose between 1 until " + num/2 + ". Choose another number");
			user = in.nextInt();
			}
		marble = num - user;
		}
	else
		{
		System.out.println("invalid type");
		}
	}	
		
	public int getMarble()
	{
	return marble;
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
	//generate random pile between 10 to 100
	System.out.println("Initial size of pile between 10 to 100 is generating..");
	System.out.println("Initial marble in a pile is : " + numGame);
	
	//computer smart, computer stupid or human turn first
	if (calc.getTurnRandom() == 0 && calc.getModeRandom() == 0)
		{
		typeGame = 1;//"Computer Mode : Smart
		/*computer smart will be firstPlayer and human is secondPlayer*/
		firstplayer = 3;
		secondplayer = 1;
		}
	else if (calc.getTurnRandom() == 0 && calc.getModeRandom() == 1)
		{
		typeGame = 2;//Computer Mode : Stupid
		/*computer stupid will be firstPlayer and human is secondPlayer*/
		firstplayer = 3;
		secondplayer = 2;
		}
	else 
		{
		typeGame = 3;//Human mode
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
	play.getPlaying(numGame, typeGame);
	System.out.println("Balance marble in a pile : " + play.getMarble());
	balanceMarble = play.getMarble();
		
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
			win = true;
			System.out.println("Game over. Player 1 win!");
			System.out.println("################################################################\n");
			break;
			}
	
		play2.getPlaying(balanceMarble, secondplayer);
		int balanceMarble2 = play2.getMarble();
		balanceMarble = balanceMarble2;
		System.out.println("Balance marble in a pile : " + balanceMarble);
		
		if(balanceMarble == 1)
			{
			win = true;
			System.out.println("Game over. Player 2 win!");
			System.out.println("################################################################\n");
			break;
			}

		}
	
	}
}
