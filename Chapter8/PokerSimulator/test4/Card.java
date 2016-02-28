//Card class represents a playing card
//package org.game.cards;
public class Card {
    private String face;
    private String suit;
    //two-argument constructor initializes Cards face and suit
    public Card(String face, String suit) {
        super();
        this.face = face;
        this.suit = suit;
    }
    //getter method to return the face value
    public String getFace() {
        return face;
    }
    //setter method to initialize the face
    public void setFace(String face) {
        this.face = face;
    }
    //getter method to return the suit value
    public String getSuit() {
        return suit;
    }
    //setter method to initialize the suit
    public void setSuit(String suit) {
        this.suit = suit;
    }
    //return String representation of Card object
    public String toString() {
        return face + " of " + suit;
    }
}//end of class