import java.util.*;
/**
*  
* @param pile class generates a random pile of marbles to be used in game class. Ths number of marbles is between 10-100 inclusive.
 * It also calculates the number of marbles removed
*/ 

public class Pile {

    private int marbles = 0;
    Random rand = new Random(); //create new random object to generate random number


/**
    *  
    * @param pile constructer sets marble pile to random number between 1-100
    */ 
    public Pile(){

        this.marbles = rand.nextInt(89)+11;
    }

    /**
    *  
    * @param getMarbles returns the current number of marbles in the game
    */ 


    public int getMarbles(){
        return this.marbles;
    }

    /**
    *  
    * @param removeMarbles accepts an int vaiarble to remove from the stack of marbles
    */ 


    public void removeMarbles(int takeMarb){
        this.marbles -= takeMarb;
    }

    public String toString(){ //can be implicitly called and relevant information about the internal state of the object. Shows the current amount of marbles in stack.
        return this.marbles + "marbles left in pile.";
    }
}