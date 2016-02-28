//package PJ4;
 
import java.util.*;
 
/** class PlayingCardException: It is used for errors related to Card and Deck objects
 *  Do not modify this class!
 */
class PlayingCardException extends Exception {
 
    /* Constructor to create a PlayingCardException object */
    PlayingCardException (){
		super ();
    }
 
    PlayingCardException ( String reason ){
		super ( reason );
    }
}
 
 
/** class Card : for creating playing card objects
 *  it is an immutable class.
 *  Rank - valid values are 1 to 13
 *  Suit - valid values are 0 to 3
 *  Do not modify this class!
 */
class Card {
	
    /* constant suits and ranks */
    static final String[] Suit = {"Clubs", "Diamonds", "Hearts", "Spades" };
    static final String[] Rank = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
 
    /* Data field of a card: rank and suit */
    private int cardRank;  /* values: 1-13 (see Rank[] above) */
    private int cardSuit;  /* values: 0-3  (see Suit[] above) */
 
    /* Constructor to create a card */
    /* throw PlayingCardException if rank or suit is invalid */
    public Card(int rank, int suit) throws PlayingCardException { 
	if ((rank < 1) || (rank > 13))
		throw new PlayingCardException("Invalid rank:"+rank);
	else
        	cardRank = rank;
	if ((suit < 0) || (suit > 3))
		throw new PlayingCardException("Invalid suit:"+suit);
	else
        	cardSuit = suit;
    }
 
    /* Accessor and toString */
    /* You may impelemnt equals(), but it will not be used */
    public int getRank() { return cardRank; }
    public int getSuit() { return cardSuit; }
    public String toString() { return Rank[cardRank] + " " + Suit[cardSuit]; }
 
    
    // Few quick tests here 
    public static void main(String args[])
    {
	try {
	    Card c1 = new Card(1,3);    // A Spades
	    System.out.println(c1);
	    c1 = new Card(10,0);	// 10 Clubs
	    System.out.println(c1);
	    c1 = new Card(10,5);        // generate exception here
	}
	catch (PlayingCardException e)
	{
	    System.out.println("PlayingCardException: "+e.getMessage());
	}
    }
}
 
 
/** class Decks represents : n decks of playing cards
 *  Use class Card to construct n * 52 playing cards!
 *
 *  Do not add new data fields!
 *  Do not modify any methods
 *  You may add private methods 
 */
 
class Decks {
 
    /* this is used to keep track of original n*52 cards */
    private static List<Card> originalDecks;   
 
    /* this starts with n*52 cards deck from original deck   */
    /* it is used to keep track of remaining cards to deal */
    /* see reset(): it resets dealDecks to a full deck      */
    private static List<Card> dealDecks;
    
	private static List<Card> newDeal;
    /* number of decks in this object */
    private int numberDecks;
 
 
    /**
     * Constructor: Creates default one deck of 52 playing cards in originalDecks and
     * 		    copy them to dealDecks.
     *              initialize numberDecks=n
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both originalDecks & dealDecks
     */
    public Decks()
    {
    	numberDecks=1;
    	originalDecks = new ArrayList<Card>(52);
		for (int j = 0; j < 4; j++) {
			for (int i = 1; i < 14; i++) {
				Card nextCard;
				try {
					nextCard = new Card(i, j);
					originalDecks.add(nextCard);
				} catch (PlayingCardException e) {
					e.printStackTrace();
				}
			}// end for(j)
		}// end for(i)
 
		//clone original deck
		dealDecks = new ArrayList<Card>(originalDecks);
 
    }
 
 
    /**
     * Constructor: Creates n decks (52 cards each deck) of playing cards in
     *              originalDecks and copy them to dealDecks.
     *              initialize numberDecks=n
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both originalDecks & dealDecks
     */
    public Decks(int n)
    {
    	numberDecks=n;
    	originalDecks = new ArrayList<Card>(numberDecks*52);
	    for (int k=0; k<2; k++){
			for (int j = 0; j < 4; j++) {
				for (int i = 1; i < 14; i++) {
					Card nextCard;
					try {
						nextCard = new Card(i, j);
						originalDecks.add(nextCard);
					} catch (PlayingCardException e) {
						e.printStackTrace();
					}
				}// end for(j)
			}// end for(i)
	    }//end for(k)
		//clone original deck
		dealDecks = new ArrayList<Card>(originalDecks);
		 
    }
	
    /**
     * Task: Shuffles cards in deal deck.
     * Hint: Look at java.util.Collections
     */
    public void shuffle()
    {
    	Collections.shuffle(dealDecks);
    }
 
    /**
     * Task: Deals cards from the deal deck.
     *
     * @param numberCards number of cards to deal
     * @return a list containing cards that were dealt
     * @throw PlayingCardException if numberCard > number of remaining cards
     *
     * Note: You need to create ArrayList to stored dealt cards
     *       and should removed dealt cards from dealDecks
     *
     */
	public static List<Card> deal(int numberCards) throws PlayingCardException{
		newDeal = new ArrayList<Card>(numberCards);
    	
		for (int i = 0; i < numberCards; i++) {
			newDeal.add(dealDecks.remove(0));
		}
    	
    	
		return newDeal;
	}
    
 
    /**
     * Task: Resets deal deck by getting all cards from the original deck.
     */
    
   
    public static void reset()
    {
    	dealDecks = new ArrayList<Card>(originalDecks);
     }
 
    /**
     * Task: Return number of remaining cards in deal deck.
     */
    public static int remain()
    {
    	return dealDecks.size();
    }
 
    /**
     * Task: Returns a string representing cards in the deal deck 
     */
 
    
    
    public String toString()
    {
    	return ""+dealDecks;
    }
    static List<Card> currentHand;
 
    /* Quick test                   */
    /*                              */
    /* Do not modify these tests    */
    /* Generate 2 decks of cards    */
    /* Loop 2 times:                */
    /*   Deal 30 cards for 4 times  */
    /*   Expect exception last time */
    /*   reset()                    */
 
public static void main(String args[]) {
 
        System.out.println("*******    Create 2 decks of cards      *********\n\n");
        Decks decks  = new Decks(2);
         
	for (int j=0; j < 2; j++)
	{
        	System.out.println("\n************************************************\n");
        	System.out.println("Loop # " + j + "\n");
		System.out.println("Before shuffle:"+decks.remain()+" cards");
		System.out.println("\n\t"+decks);
        	System.out.println("\n==============================================\n");
 
                int numHands = 4;
                int cardsPerHand = 30;
 
        	for (int i=0; i < numHands; i++)
	 	{
	    		decks.shuffle();
		        System.out.println("After shuffle:"+decks.remain()+" cards");
		        System.out.println("\n\t"+decks);
			try {
            		    System.out.println("\n\nHand "+i+":"+cardsPerHand+" cards");
            		    System.out.println("\n\t"+decks.deal(cardsPerHand));
            		    System.out.println("\n\nRemain:"+decks.remain()+" cards");
		            System.out.println("\n\t"+decks);
        	            System.out.println("\n==============================================\n");
			}
			catch (PlayingCardException e) 
			{
		 	        System.out.println("*** In catch block : PlayingCardException : Not enough cards to deal "+e.getMessage());
			}
		}
 
 
		decks.reset();
 
	
    }}
 
}