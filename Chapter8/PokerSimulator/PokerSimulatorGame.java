//Chapter8 - Project P8.1

import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class PokerSimulatorGame
{
	private static final int NUM_OF_CARD = 52;
	private static final int CARD_IN_SUIT = 13;
	private static final int NUM_SUIT = 4;
	public ArrayList<PokerSimulatorCard> card = new ArrayList<PokerSimulatorCard>(); //instantiate card class
	public ArrayList<PokerSimulatorCard> player = new ArrayList<PokerSimulatorCard>();
	private int cardDeal;
	private int cardValueScore;
	private int cardSuitScore;
	Scanner in = new Scanner(System.in);
	
	public PokerSimulatorGame()
	{
	cardDeal = 0;
	cardValueScore = 0;
	}
	
	public void setCardShuffle()//set card and shuffle
	{
	for (int i = 1; i <= NUM_SUIT; i++) //set card for SUIT
		{
		for (int j = 1; j <= CARD_IN_SUIT; j++) //set card for number
			{
			card.add(new PokerSimulatorCard(i,j)); 
			}		
		}

	for (int k = card.size() - 1; k > 0; k--) //shuffle all cards
		{
		int numRandom = (int)(Math.random()*k+1); //get random number
		PokerSimulatorCard temp = card.get(k); //start with first number in array put in temp array
		card.remove(k); //remove number in array
		card.add(k, card.get(numRandom)); //replace with random number
		card.remove(numRandom); //remove repeated random number in array
		card.add(numRandom, temp); //replace in temp array
		}		
	}
	
	public void getAllCard() //to print all card that has been shuffle
	{
	for (int i = 0; i < card.size(); i++) //for (PokerSimulatorCard a : card)
		{
		int j = i + 1; //to get the number of card id
		System.out.println ("Card " + j + " : " + card.get(i).getValueString() + " of " + card.get(i).getSuitString());//System.out.println("Card : " + a.getValueString() + " of " + a.getSuitString());
		}
	System.out.println ("\nAll card in deck : " + card.size() + "\n"); //get total card in deck
	}
	
	 /*Player start with empty hand. Five top cards are removed from deck and give to player*/
	public void setPlayerCard()
	{
	for (int i = 0; i < player.size(); i++) //get all card in player arraylist
		{
		int j = i + 1; //to get the number of card id
		System.out.println ("Player Card " + j + " : " + player.get(i).getValueString() + " of " + player.get(i).getSuitString()); //to print all card in player arraylist
		}
	System.out.println("\nCards in player hand : " + player.size()); //get card in player hand
	}	
	
	public void getCardScore()
	{
	for (int i = 0; i < player.size(); i++)
		{ 
		String tempVal1 = player.get(i).getValueString(); //check for first number in value
		String tempSui1 = player.get(i).getSuitString(); //check for first number in suit
		for (int j = 0; j < player.size(); j++)
			{
			String tempVal2 = player.get(j).getValueString();//check against the next number in value
			if (tempVal1.equalsIgnoreCase(tempVal2)) 
				{
				cardValueScore++;
				}
				
			String tempSui2 = player.get(j).getSuitString();//check against the next number in suit
			if (tempSui1.equalsIgnoreCase(tempSui2))
				{
				cardSuitScore++;
				}
			}

		String[] straight = new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"}; //declare new array for straight
		String tempVal3 = Arrays.toString(straight); //convert array to string, checking for straight
		for (int j = 0; j < tempVal3.length()-5; j++)//start from Ace
			{
			if (tempVal1.equalsIgnoreCase(tempVal3))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 100;
				System.out.println(cardValueScore);
				}
			}
			
		for (int j = 1; j < tempVal3.length()-4; j++)//start from Two
			{
			if (tempVal1.equalsIgnoreCase(tempVal3))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 100;
				System.out.println(cardValueScore);
				}
			}
		
		for (int j = 2; j < tempVal3.length()-3; j++)//start from Three
			{
			if (tempVal1.equalsIgnoreCase(tempVal3))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 100;
				System.out.println(cardValueScore);
				}
			}
			
		for (int j = 3; j < tempVal3.length()-2; j++)//start from Four
			{
			if (tempVal1.equalsIgnoreCase(tempVal3))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 100;
				System.out.println(cardValueScore);
				}
			}
			
		for (int j = 4; j < tempVal3.length()-1; j++)//start from Five
			{
			if (tempVal1.equalsIgnoreCase(tempVal3))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 100;
				System.out.println(cardValueScore);
				}
			}
		
		for (int j = 5; j < tempVal3.length(); j++)//start from Six
			{
			if (tempVal1.equalsIgnoreCase(tempVal3))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 100;
				System.out.println(cardValueScore);
				}
			}
			
		String[] royal = new String[]{"Ace", "Ten", "Jack", "Queen", "King"}; //declare new array for royal
		String tempVal4 = Arrays.toString(royal); //convert array to string, checking for royal
		for (int j = 0; j < tempVal4.length(); j++)//start from Ace
			{
			if (tempVal1.equalsIgnoreCase(tempVal4))
				{
				cardValueScore++;
				cardValueScore = cardValueScore + 200;
				System.out.println(cardValueScore);
				}
			}
		
		}
		
			if(cardValueScore == 205 && cardSuitScore == 25)
				{
				System.out.println ("\nYou score - Royal Flush : Payout JavaDollar 250 " + cardSuitScore);
				}
			else if(cardValueScore == 105 && cardSuitScore == 25)
				{
				System.out.println ("\nYou score - Straight Flush : Payout JavaDollar 50 " + cardSuitScore);
				}
			else if(cardValueScore < 105 && cardSuitScore == 25)
				{
				System.out.println ("\nYou score - Flush : Payout JavaDollar 5 " + cardSuitScore);
				}
		   else if(cardValueScore == 5)
				{
				System.out.println ("\nYou score - No Pair ");
				}
			else if(cardValueScore == 7)
				{
				System.out.println ("\nYou score - One Pair : Payout JavaDollar 1 ");
				}
			else if(cardValueScore == 9)
				{
				System.out.println ("\nYou score - Two Pair : Payout JavaDollar 2 ");
				}
			else if(cardValueScore == 11)
				{
				System.out.println ("\nYou score - Three Of A Kind : Payout JavaDollar 3 ");
				}
			else if(cardValueScore == 13)
				{
				System.out.println ("\nYou score - Full House : Payout JavaDollar 6 ");
				}
			else if(cardValueScore == 16)
				{
				System.out.println ("\nYou score - Four Of A Kind : Payout JavaDollar 25 " + cardValueScore);
				}
			else if(cardValueScore == 105)
				{
				System.out.println ("\nYou score - Straight : Payout JavaDollar 4" + cardValueScore);
				}
	}
	
	public void setRejectCard() //player to reject cards in hand
	{
	int reject = 0;
	System.out.print("How many card do you want to reject? Choose between 1 until 5 only : ");
	reject = in.nextInt();
	
	while (reject < 0 || reject > 5 || reject == 0) //compare input to valid number only
		{
		System.out.print("Choose between 1 until 5 only : ");
		reject = in.nextInt();
		}
		
	if (reject == 5)
		{
		player.removeAll(player);
		for (int i = 5; i < 10; i++) 
			{
			player.add(card.get(i)); //add 5 card to player arraylist 
			}
		setPlayerCard();
		getCardScore();
		}
	else if (reject == 4)
		{
		for (int j = 5; j < 9; j++)
			{
			player.add(card.get(j));
			}
			for (int i = 0; i < 4; i++)
			{
			player.remove(i%1);
			}
		setPlayerCard();
		getCardScore();
		}
	else if (reject == 3)
		{
			for (int j = 5; j < 8; j++)
				{
				player.add(card.get(j));
				}
			for (int i = 0; i < 3; i++)
				{
				player.remove(i%1);
				}
		setPlayerCard();
		getCardScore();
		}
	else if (reject == 2)
		{
			for (int j = 5; j < 7; j++)
				{
				player.add(card.get(j));
				}
			for (int i = 0; i < 2; i++)
				{
				player.remove(i%1);
				}
		setPlayerCard();
		getCardScore();
		}
	else if (reject == 1)
		{
			for (int j = 5; j < 6; j++)
				{
				player.add(card.get(j));
				}
			for (int i = 0; i < 1; i++)
				{
				player.remove(i%1);
				}
		setPlayerCard();
		getCardScore();
		}
	}
	
	public void setDealCard() //starting the game deal card
	 {
	 for (int i = 0; i < 5; i++) 
		{
		player.add(card.get(i)); //add 5 card to player arraylist 
		cardDeal++;
		}
	
	for (int i = cardDeal; i < card.size(); i++) //for (PokerSimulatorCard a : card)
		{
		int j = i-4; //to get the number of card id
		System.out.println ("Remaining Card " + j + " : " + card.get(i).getValueString() + " of " + card.get(i).getSuitString());//System.out.println("Card : " + a.getValueString() + " of " + a.getSuitString());
		}
	System.out.println ("\nCards remain in deck : " + (card.size()-cardDeal) + "\n"); //get the remaining of card in deck
	
	setPlayerCard();

	System.out.print("\nDo you want to reject any of these cards? y/n : "); //option to reject any card
	String choice = in.next();
	System.out.println();
	
	String n = "n";
	String y = "y";
	while (!choice.equalsIgnoreCase(n) && !choice.equalsIgnoreCase(y)) //compare input to y and n
		{
		System.out.print("Enter 'n' or 'y' only : ");
		choice = in.next();
		}
	System.out.println();
	
	if (choice.equalsIgnoreCase("n"))
		{
		setPlayerCard();
		getCardScore();
		}
	else if (choice.equalsIgnoreCase("y"))
		{
		setRejectCard();		
		}
	}
}