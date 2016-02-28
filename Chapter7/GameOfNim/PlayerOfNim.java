//Chapter7 - Project 7.2

import java.util.Random;
import java.util.Scanner;

public class PlayerOfNim
{
	public static final int COMPUTER = 0;
	public static final int HUMAN = 1;
	public static final int SMART = 0;
	public static final int STUPID = 1;	

	private Random gen;
	private int num;
	private int type;
	private int marble;
	
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
	//int marble = 0;
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
}
