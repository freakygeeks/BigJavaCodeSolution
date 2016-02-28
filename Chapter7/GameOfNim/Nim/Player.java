import java.util.*;

/**
*  
* @param player class sets the player type to enum and then dictates behavior based on selection in Game class.
*/


public class Player {

    Scanner input = new Scanner(System.in);
    Random marbles = new Random(); //creates random object of random class

    public enum Type{HUMAN,SMART_COMPUTER,SIMPLE_COMPUTER} //declare enum objects

    private Type type;
    /**
    *  Constructor
    * @param t indicates which of the three allowable Types this Player object will be
    */ 
    public Player(Type t){
        this.type = t;
    }

    /**
        *  
    * @param t allows for enum type to be re-assigned
    */ 

    public void setType(Type t){
        this.type = t;
    }


    /**
    *  
    * @param playTurn determines the computer and human behavior that dictates the course of the game
    */ 


    public int playTurn(int pileSize){

        int marblesRemoved = 0; //sets variable to 0

        if(type == Type.SIMPLE_COMPUTER){ //SIMPLE_COMPUTER makes any random move, with no strategy.

            marblesRemoved = marbles.nextInt((pileSize)/2)+1; //removes a random number between 1 and half the size of the remaining pile
        }


        else if(type == Type.SMART_COMPUTER){ //SMART_COMPUTER plays with a strategy. the computer takes off enough marbles to make the size of the pile a power of two minus 1—that is, 3, 7, 15, 31, or 63

        if(pileSize > 63)
            marblesRemoved = pileSize - 63;

        else if(pileSize > 31)
            marblesRemoved = pileSize - 31;

        else if(pileSize > 15)
            marblesRemoved = pileSize - 15;

        else if (pileSize > 7)
            marblesRemoved = pileSize - 7;

        else if(pileSize == 2)
            marblesRemoved = pileSize - 1;

        else
            marblesRemoved = marbles.nextInt((pileSize)/2)+1; //if the size of the pile is between 3-7, SMART_COMPUTER makes random legal move


        }

        else if (type == Type.HUMAN){ //HUMAN chooses the amount of marbles to remove

            System.out.println("Please choose a number of marbles to remove between 1 and " + (pileSize/2));
            marblesRemoved = input.nextInt();

            while(marblesRemoved <=0 || marblesRemoved > pileSize/2){ //user input check to make sure number is between the correct values
                System.out.println("You must choose a number between 1 and " + (pileSize/2) + ". Please choose another number.");
                marblesRemoved = input.nextInt();
            }
        }

        return marblesRemoved; //return marbles removed based on player enum type
    }


    public String toString(){ //can be implicitly called and relevant information about the internal state of the object. shows which enum player type is being played.
        return this.type + "Player type selected.";
    }
}