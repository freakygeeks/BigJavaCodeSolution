import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class CardDeck
{
        private static final int NUMBER_OF_CARDS = 52;
        private static final int CARDS_FOR_EACH_SUIT = 13;
        private static final int NUMBER_OF_SUITS =4; 
         public ArrayList<Card> deck = new ArrayList<Card>();
         public ArrayList<Card> hand = new ArrayList<Card>();
        private Hand   playingHand;
        private int cardsRemaining;
        private int      cardsDelt;
        
        public CardDeck()
        {
                cardsRemaining = NUMBER_OF_CARDS;
                cardsDelt          = 0;
                for(int i=0;i<NUMBER_OF_SUITS;i++)
                {
                        for(int j=1;j<=CARDS_FOR_EACH_SUIT;j++)
                        {
                                deck.add(new Card(i,j));
                        }
                }
        }
        
        public void printAllCards()
        {
                for(Card c:deck)
                {
                        System.out.println("Suit: "+c.getSuitAsString()+" Value: "+ c.getValueAsString());
                }
        }
        
        public void shuffle()
        {
                for(int i=deck.size()-1;i>0;i--)
                {
                        int randomNum = (int)(Math.random()*i+1);
                        Card Temp = deck.get(i);
                        deck.remove(i);
                        deck.add(i,deck.get(randomNum));
                        deck.remove(randomNum);
                        deck.add(randomNum, Temp);
                }
                cardsDelt = 0;
        }
        /**
         * The player or players should start out with an empty hand. 
         * When called,a new hand should be initialized. Five top cards are removed from the deck and added 
         * to the hand. Note: Five cards are deducted from the arrayList of cards 
         * */
        public void dealCard()
        {
                playingHand = new Hand(hand);
                Scanner in = new Scanner(System.in);
                System.out.println("Cards in deck: "+deck.size());
                for(int i=deck.size();i>=deck.size()-4;i--)
                {
                        playingHand.handArrayList.add(deck.get(i-1));
                }
                System.out.println("Cards in hand: " +playingHand.handArrayList.size());
                System.out.println(" ");
                for(int i=0;i<5;i++)
                {
                deck.remove(deck.size()-1);
                cardsDelt++;
                }
                
                System.out.println("Cards Left in deck: "+ deck.size()+"\n");
                playingHand.printCardsInHand();
                System.out.println("Do you choose to reject any of these cards? y/n ");
                String choice = in.next();
                if(choice.equalsIgnoreCase("n"))
                {
                        playingHand.evulateHand();
                        System.out.println(" ");
                        playingHand.printCardsInHand();
                }
                else if(choice.equalsIgnoreCase("y"))
                {
                        dealCard(playingHand.RejectCards());
                }
        }
        
        public void dealCard(int numberOfRejectedCards)
        {
                for(int i=deck.size();i>=deck.size()-numberOfRejectedCards+1;i--)
                {
                        playingHand.handArrayList.add(deck.get(i-1));
                }
                System.out.println("Cards in hand: " +playingHand.handArrayList.size());
                System.out.println(" ");
                for(int i=0;i<numberOfRejectedCards;i++)
                {
                        deck.remove(deck.size()-1);
                        cardsDelt++;
                }
                System.out.println(" ");
                playingHand.printCardsInHand();
        }
        
        public ArrayList<Card> getHand()
        {
                return hand;
        }
        
        public ArrayList<Card> getCardDeck()
        {
                return deck;
        }
        
        public int countcardsLeft()
        {
                int cardCount = cardsRemaining - cardsDelt;
                cardsRemaining = cardCount;
                return cardsRemaining;
        }

}