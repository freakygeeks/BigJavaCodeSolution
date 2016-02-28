//Card class represents a deck of cards
//package org.game.cards;
import java.util.Random;
public class Deck {
    private final String faces[] = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private final String suits[]={"Hearts","Diamonds","Clubs","Spades"};
    private Card deck[];
    private final int TOTAL_CARDS=52;
    private Random randNum;    
    //no-argument constructor fills the deck of cards
    public Deck(){        
        deck = new Card[TOTAL_CARDS];
        randNum = new Random();
        for(int i=0;i<deck.length;i++){
            deck[i] = new Card(faces[i%13],suits[i/13]);
        }
    }
    
    //shuffles the deck
    public void shuffle(){
        for(int i=0;i<deck.length;i++){
            int j = randNum.nextInt(TOTAL_CARDS);
            Card c = deck[i];
            deck[i] = deck[j];
            deck[j] = c;
        }
    }        

    //returns the individual card in the deck
    public Card getCard(int index){
        return deck[index];
    }
}//end of class