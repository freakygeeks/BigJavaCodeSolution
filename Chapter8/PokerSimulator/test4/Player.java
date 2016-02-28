//class to represent a player
//package org.game.cards;
public class Player {
    public final static int MAX_CARD = 5;
    private Card cards[];
    //constructor initializes 5 cards in each hand
    public Player() {
        cards = new Card[MAX_CARD];
    }
    //returns all the cards in hand
    public Card[] getCards() {
        return cards;
    }
    //get the cards at a particular position
    public Card getCardAtIndex(int index) {
        if (index >= 0 && index < MAX_CARD)
            return cards[index];
        else
            return null;
    }
   //sets the card at particular position
    public void setCardAtIndex(Card c, int index) {
        if(index >= 0 && index < MAX_CARD)
            cards[index] = c;
    }
    //counts number of matched pair
    public int countPair() {
        int count = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getFace().equals(cards[j].getFace())){
                    count++;
                }
            }
        }
        return count;
    }

    //checks if it is a flush or not i.e all five cards of same suit
    public boolean isFlush() {
        int count = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getSuit().equals(cards[j].getSuit())) {
                    count++;
                }
            }
        }
        if(count == 5)
            return true;
        else
            return false;
    }    
}