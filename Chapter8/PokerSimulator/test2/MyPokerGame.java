//package PJ4;
import java.util.*;
 
/* This is the main poker game class.
 * It uses Decks and Card objects to implement poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */
 
public class MyPokerGame {
 
    // default constant values
    private static final int startingBalance=500;
    private static final int numberOfCards=5;
 
    // default constant payout value and currentHand types
    private static final int[] multipliers={1,2,3,5,6,9,25,50,250};
    private static final String[] goodHandTypes={ 
	  "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush     ", 
	  "Full House", "Four of a Kind", "Straight Flush", "Royal Flush", "Sorry, you lost." };
 
    // must use only one deck
    private static Decks oneDeck = new Decks(1);
 
    // holding current poker 5-card hand, balance, bet    
    private static List<Card> currentHand;
    private int balance;
    private int bet;
    private boolean playing=true;
    private static List<Integer> discardArray;
 
    /** default constructor, set balance = startingBalance */
    public MyPokerGame()
    {
	this(startingBalance);
    }
 
    /** constructor, set given balance */
    public MyPokerGame(int balance)
    {
	this.balance= balance;
    }
 
    /** This display the payout table based on multipliers and goodHandTypes arrays */
    private void showPayoutTable()
    { 
	System.out.println("\n\n");
	System.out.println("Payout Table   	      Multiplier   ");
	System.out.println("=======================================");
	int size = multipliers.length;
	for (int i=size-1; i >= 0; i--) {
		System.out.println(goodHandTypes[i]+"\t|\t"+multipliers[i]);
	}
	System.out.println("\n-----------------------------------");
    }
 
    private void askShowPayoutTable()
    { 
    	
    	boolean loop=true; 
    	boolean again=true;
    	Scanner in = new Scanner(System.in);
    	
    	while (loop){
        	System.out.println("Show payout table? (y or n)?");
        	String playAgain=in.next();
 
        	if (playAgain.equalsIgnoreCase("y")){
      		  again=true;
      		  loop=false;
 
      		  }
      		  
      		else if (playAgain.equalsIgnoreCase("n")){ 
      		  again=false;
      		  loop=false;
      		}
      		else
      	     System.out.println("Sorry, I didn't catch that. Please answer y/n");
    		}
    	 if (again) showPayoutTable();
    }
 
    /** Check current currentHand using multipliers and goodHandTypes arrays
     *  Must print yourHandType (default is "Sorry, you lost") at the end of function.
     *  This can be checked by testCheckHands() and main() method.
     */
	
	private static void sortByNumber(List currentHand){
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
 
			int n, j, min_j;
			for (n = 0; n < anArray.length; n++){
				min_j=n;
				for(j=n+1; j<anArray.length; j++){	 
					if (anArray[j].getRank()<anArray[min_j].getRank())
						min_j=j;
						}
					Card tempCard = anArray[n];
					anArray[n]=anArray[min_j];
					anArray[min_j]=tempCard;
					}
	
				currentHand.clear();
				for (int k=0; k<anArray.length; k++){
						currentHand.add(anArray[k]);
					}			
	}
	
	private static void sortBySuit(List currentHand){
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
 
			int n, j, min_j;
			for (n = 0; n < anArray.length; n++){
				min_j=n;
				for(j=n+1; j<anArray.length; j++){	 
					if (anArray[j].getSuit()<anArray[min_j].getSuit())
						min_j=j;
						}
					Card tempCard = anArray[n];
					anArray[n]=anArray[min_j];
					anArray[min_j]=tempCard;
					}
	
				currentHand.clear();
				for (int i=0; i<anArray.length; i++){
						currentHand.add(anArray[i]);
					}			
			}
 
	private static boolean isOnePair(List currentHand){
		
				sortByNumber(currentHand);
				
				Card[] anArray = new Card[currentHand.size()];
				
				for (int i = 0; i < anArray.length; i++) {
					anArray[i]=(Card)currentHand.get(i);
					}
				
				//check for pair
				int pairs=0;
				int count=0;
 
				for (int j=1; j<13;j++){			
					for (int i=0; i<5; i++){
						if (anArray[i].getRank()==j){
							count++;
						}//end if()
					}//end for(i)	
					if(count==2) pairs++;
					count=0;
				}//end for(j)
				if (pairs==1) return true;
				else return false;
	}
	
	private static boolean isRoyalPair(List currentHand){
		
		sortByNumber(currentHand);
		
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
		
		//check for pairs
		int pairs=0;
		int count=0;
 
		for (int j=11; j<14;j++){			
			for (int i=0; i<5; i++){
				if (anArray[i].getRank()==j){
					count++;
				}//end if()
			}//end for(i)	
			if(count==2) pairs++;
			count=0;
		}//end for(j)
		if (pairs==1) return true;
		else return false;
	}
	
	private static boolean isTwoPair(List currentHand){
 
		sortByNumber(currentHand);
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
	      if ( anArray.length != 5 )
		         return(false);
		
		//check for pairs   
	  boolean a1, a2, a3;
 
	      if ( anArray.length != 5 )
	         return(false);
	      
	      //Checking: a a  b b x
		 
	      a1 = anArray[0].getRank() == anArray[1].getRank() &&
	           anArray[2].getRank() == anArray[3].getRank() &&
	           anArray[4].getRank() != anArray[0].getRank() &&
	           anArray[4].getRank() != anArray[2].getRank();
 
	       //Checking: a a x  b b
	      
	      a2 = anArray[0].getRank() == anArray[1].getRank() &&
	           anArray[3].getRank() == anArray[4].getRank() &&
	    	   anArray[2].getRank() != anArray[1].getRank() &&
	    	   anArray[2].getRank() != anArray[3].getRank();
 
	      //Checking: x a a  b b
	      
	      a3 = anArray[1].getRank() == anArray[2].getRank() &&
	           anArray[3].getRank() == anArray[4].getRank() &&
	    	   anArray[0].getRank() != anArray[1].getRank() &&
	      	   anArray[0].getRank() != anArray[3].getRank();
	      
	      return( a1 || a2 || a3 );
	   
	}
 
	private static boolean isThreeOfAKind(List currentHand){
		sortByNumber(currentHand);
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
		
		//check for pairs   
		boolean a1, a2;
 
	      if ( anArray.length != 5 )
	         return(false);
 
	      //Checking: a a a x x
                      
	      a1 = anArray[0].getRank() == anArray[1].getRank() &&
	           anArray[1].getRank() == anArray[2].getRank() ;
 
 
	      //Checking: x x b b b
 
	      a2 = anArray[2].getRank() == anArray[3].getRank() &&
	           anArray[3].getRank() == anArray[4].getRank() ;
 
	      return( a1 || a2 );
	   
	}
	
	private static boolean isStraight(List currentHand){
		sortByNumber(currentHand);
		Card[] anArray = new Card[currentHand.size()];
			
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
				}//end for()
	
	     int testRank = anArray[0].getRank() + 1;
	
	     for (int i = 1; i < 5; i++ ) {
	        if ( anArray[i].getRank() != testRank )
	           return(false);        // Straight failed...
	           testRank++;   // Next card in hand
	     	}//end for()
	
	     return(true);        // Straight found !				
		}//end isStraight()
	
	private static boolean isFlush(List currentHand){
		//sortBySuit(currentHand);
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
		
		int count = 0;
        for (int i = 0; i < anArray.length; i++) {
            for (int j = i + 1; j < anArray.length; j++) {
                if (anArray[i].getSuit()==(anArray[j].getSuit())) {
                    count++;
                }
            }
        }
        if(count == 10)
            return true;
        else
            return false;
	}
 
	private static boolean isFullHouse(List currentHand){
		if (isOnePair(currentHand)&&isThreeOfAKind(currentHand))
			return true;
			else return false;
 
	}
	
	private static boolean isFourOfAKind(List currentHand){
		sortByNumber(currentHand);
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
		
		//check for pairs   
		boolean a1, a2;
 
	      if ( anArray.length != 5 )
	         return(false);
 
 
	         //Checking: a a a a x
                      
	      a1 = anArray[0].getRank() == anArray[1].getRank() &&
	           anArray[1].getRank() == anArray[2].getRank() &&
	           anArray[2].getRank() == anArray[3].getRank() ;
 
 
	         //Checking: x b b b b
 
	      a2 = anArray[1].getRank() == anArray[2].getRank() &&
	           anArray[2].getRank() == anArray[3].getRank() &&
	           anArray[3].getRank() == anArray[4].getRank() ;
 
	      return( a1 || a2 );
	   
	}	
	
	private static boolean isStraightFlush(List currentHand){
		
		if ( currentHand.size() != 5 ) return(false);
		if (isStraight(currentHand) && isFlush(currentHand)) return true;
		else return false;
	}
	
	private static boolean isRoyalFlush(List currentHand){
		if ( currentHand.size() != 5 ) return(false);
		Card[] anArray = new Card[currentHand.size()];
		
		for (int i = 0; i < anArray.length; i++) {
			anArray[i]=(Card)currentHand.get(i);
			}
		
		if (anArray[0].getRank()==1 && anArray[1].getRank()==10 && 
		    anArray[2].getRank()==11 && anArray[3].getRank()==12 && 
		    anArray[4].getRank()==13) 
				return true;
		else return false;
		
	}
	    
    private int checkHands()
    {
    	int result=9;
    	
    	if (isRoyalPair(currentHand)) result=0;
    	
    	if (isTwoPair(currentHand)) result=1;
    	 
    	if (isThreeOfAKind(currentHand)) result=2;
    	System.out.println("");
    	if (isStraight(currentHand)) result=3;
    	
    	if (isFlush(currentHand)) result=4;
 
    	if (isFullHouse(currentHand)) result=5;
 
    	if (isFourOfAKind(currentHand)) result=6;
 
    	if (isStraightFlush(currentHand)) result=7;
 
    	if (isRoyalFlush(currentHand)) result=8;
    	
    	System.out.println(goodHandTypes[result]);
    	//System.out.println("RESULT: "+result);
    	return result;
    }
 
 
    //*************************************************
    //*   add new private methods here ....
    
    //Adjust balance after checking cards
    private void payOut(int payOut){
 
    	if (payOut==9){
    		//if losing hand, deduct bet
    		balance = balance-bet;
    	}
    	//otherwise payout
    	else if (payOut!=9){
    		balance=balance+(bet*multipliers[payOut]);
    	}
    }
    
    //Check players funds
    private int getBalance(){
    	return this.balance;
    }
    
    //what was the bet?
    private int getBet(){
    	return bet;
    }
    
    //place a bet
    private void placeBet(){
    	Scanner in = new Scanner(System.in);
    	boolean loop=true;
    	while (loop){
    		System.out.print("Enter bet: ");
    		bet=in.nextInt();
    		if (verifyBet(bet)) loop=false;
    		else System.out.println("Insufficient funds. Enter a smaller amount.");
    	}
    }
    
    public static Card getCardFromDeck(int i){
    	Card card = currentHand.get(i);
    	return card;
    }
    //make sure there are sufficient funds for the bet
    private boolean verifyBet(int newBet){
    	boolean verify= false;
    	if (newBet<=balance)	verify=true;
    	return verify;
    }
    
    List<Card> tempHand = new ArrayList<Card>();
    
	private static List<Card> discard(List currentHand){
		List<Card> tempHand = new ArrayList<Card>();
		    	discardArray  = new ArrayList<Integer>();
		    	Scanner in = new Scanner(System.in);
		    	String str1=null;
		    	
		int count=1;
		    	
		while (count>0){
					count=0;
		    		System.out.println("Enter positions of cards to keep (e.g. 1 4 5): ");
			    	
		    		str1 = in.nextLine();
			    	
			    	if (!str1.isEmpty()){
			    	
				    	String str2[] = str1.split(" ");
	
			    		// check if user entered more than 5 cards
				    	if (str2.length>5){ 
				    		System.out.println("Error, too many values. Choose up to 5 cards only. ");
				    		count++;
				    		}
				    	
				    	for (int i=0; i < str2.length; i++) { 
				    		int k = Integer.parseInt(str2[i]); 
				    		discardArray.add(i, k);
				    		}
				    	//Check if each card number is between 1 and 5
				    	for (int i=0; i < discardArray.size(); i++) { 
				    		 
				    		if (discardArray.get(i)<1 || discardArray.get(i)>=6){
				    			System.out.println("Error, position number out of range. Choose 1 - 5");
				    			count++;
				    			//break;
				    			}
				    		}//end for (int i=0; i < discardArray.size(); i++)
						
				    if(count==0){	
						//extract held cards, add them into new array
						for (int i=0; i<discardArray.size(); i++){
							int x =discardArray.get(i);
							tempHand.add(getCardFromDeck(x-1));
							}
						
						System.out.println("Held Cards: "+tempHand);
							
							//deal more cards
					    	try {
								tempHand.addAll(oneDeck.deal(5-discardArray.size()));
							} catch (PlayingCardException e) {
								e.printStackTrace();
							}
				    	}//end if(count==0)
				    discardArray.clear();
			    }//end if(str1.is not Empty())
		}// end while (count>0)
		
			    if (str1.isEmpty()){
			    			tempHand.clear();
			    			System.out.println("No cards held.");
			    	try { tempHand.addAll(oneDeck.deal(5));
						} 
			    	catch (PlayingCardException e) {
						e.printStackTrace();
						}
			     	
			    	}//end if (str1.is Empty())	
 
			    return tempHand;
		    }    
    //End of hand, play again?
    public static boolean playAgain(){
    	
    	boolean loop=true; 
    	boolean again=true;
    	Scanner in = new Scanner(System.in);
    	
    	while (loop){
        	System.out.println("One more game (y or n)?");
        	String playAgain=in.next();
 
        	if (playAgain.equalsIgnoreCase("y")){
      		  again=true;
      		  loop=false;
 
      		  }
      		  
      		else if (playAgain.equalsIgnoreCase("n")){ 
      		  again=false;
      		  loop=false;
      		}
      		else
      	     System.out.println("Sorry, I didn't catch that. Please answer y/n");
    		}
    	 return again;
    	 
    	}
    
    
    //*************************************************/
 
 
    public void play() 
    {
    //The main algorithm for single player poker game 
 
    	showPayoutTable();
    	oneDeck = new Decks(1);
    	//Create a hand arrayList
    	currentHand = new ArrayList<Card>();
		while (playing) {
 
	    	System.out.println("Balance: $" +getBalance());
	    	placeBet(); 
	    	oneDeck.shuffle();
	    	
	    	//Deal the hand
	    	try {
				currentHand = new ArrayList<Card>(oneDeck.deal(5));
			} catch (PlayingCardException e) {
				e.printStackTrace();
			}	    	
 
	    	System.out.println("HAND: "+currentHand);
	    	
	    	
	    	currentHand=discard(currentHand);
	    	
	    	
	    	
	    	System.out.println("NEW HAND: "+currentHand);
	    	
	    	//Check for winning hand
			payOut(checkHands());
			
			currentHand.clear();
			System.out.println("\nYour balance: $"+balance);
			
			//end of round, play again?
			if ((balance > 0)&&(playAgain())) {;
			askShowPayoutTable();
			}	
			else {
				System.out.println("Your balance: $" + getBalance() + " Good bye!");
				playing=false;
			}
		}
}     
    /** Do not modify this. It is used to test checkHands() method 
     *  checkHands() should print your current hand type
     */ 
    public void testCheckHands()
    {
      	try {
    		currentHand = new ArrayList<Card>();
 
		// set Royal Flush
		currentHand.add(new Card(1,3));
		currentHand.add(new Card(10,3));
		currentHand.add(new Card(12,3));
		currentHand.add(new Card(11,3));
		currentHand.add(new Card(13,3));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Straight Flush
		currentHand.set(0,new Card(9,3));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Straight
		currentHand.set(4, new Card(8,1));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Flush 
		currentHand.set(0, new Card(5,3));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Four of a Kind
		currentHand.clear();
		currentHand.add(new Card(8,3));
		currentHand.add(new Card(8,0));
		currentHand.add(new Card(12,3));
		currentHand.add(new Card(8,1));
		currentHand.add(new Card(8,2));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Three of a Kind
		currentHand.set(0, new Card(11,3));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Full House
		currentHand.set(4, new Card(11,1));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Two Pairs
		currentHand.set(1, new Card(9,1));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// set Royal Pair
		currentHand.set(0, new Card(3,1));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
 
		// non Royal Pair
		currentHand.set(4, new Card(3,3));
		System.out.println(currentHand);
    		checkHands();
		System.out.println("-----------------------------------");
      	}
      	catch (Exception e)
      	{
		System.out.println(e.getMessage());
      	}
    }
 
    /* Quick testCheckHands() */
    public static void main(String args[]) 
    {
	MyPokerGame mypokergame = new MyPokerGame();
	mypokergame.testCheckHands();
    }
}