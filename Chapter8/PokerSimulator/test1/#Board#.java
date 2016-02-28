import java.util.ArrayList;

public class Board
{
        private static final ArrayList<Card> deck = new ArrayList<Card>();
        private static final ArrayList<Card> hand = new ArrayList<Card>();
        private Hand playingHand;
        private int cardsRemaining;
        public Board()
        {
                
        }
        
        /**
         * The player or players should start out with an empty hand. 
         * When called,a new hand should be initialized. Five top cards are removed from the deck and added 
         * to the hand. Note: Five cards are deducted from the arrayList of cards 
         * */
        public void dealCard(ArrayList<Card> d)
        {
                ArrayList<Card> deck = d;
                System.out.println("Cards in deck: "+deck.size());
                for(int i=deck.size();i>=deck.size()-4;i--)
                {
                        hand.add(deck.get(i-1));
                        
                }
                System.out.println("Cards in hand: " +hand.size());
                System.out.println(" ");
                for(int i=0;i<5;i++)
                {
                deck.remove(deck.size()-1);
                
                }
                playingHand = new Hand(hand);
                
                System.out.println("Cards Left in deck: "+ deck.size()+"\n");
                playingHand.printCardsInHand();
        }
        
}