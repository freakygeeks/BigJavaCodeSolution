/*************************************************************************************
The purpose of this project is to create 3 classes. Pile contains the number of marbles
in a randomly generated pile, and also a remove method to determine how many marbles are
to be removed. The player class determines the behavior of each type of player. There are
three types of players. Simple computer, Smart computer, and Human. These are all of enum
type. The program will use a randomly generated number to determine who goes first and
which level of skill the computer player is set at. Each player will draw a number of marbles
from the pile until the pile reaches 1. Whoever pulls the last marble will lose.
A player must choose between 1 and half the remaining pile.
***************************************************************************************/

import java.util.*;

public class Game {

    private static void printHeading(int projectNum, String projectName){ //creates an identifier method.

        System.out.println("Chris Olson");
        System.out.println("CMSC 255-002, Spring 2013");
        System.out.println("Project " + projectNum);
        System.out.println(projectName);
        System.out.println();
    }

    public static void main(String[] args) {

        printHeading(8,"Nim");
        Scanner in = new Scanner(System.in);

        Pile marbles = new Pile(); //creates initial Pile object


        //Sets variables and objects to enum type
        int marblesToRemove = 0;
        Player humanPlayer = new Player(Player.Type.HUMAN);
        Player compPlayer = new Player(Player.Type.SMART_COMPUTER);
        Player secondPlayer = new Player(Player.Type.HUMAN);
        Player firstPlayer = new Player(Player.Type.HUMAN);
        Random randomNum = new Random(); //creates new random object to generate random numbers
        int selection = 0;


        //Interface
        System.out.println("**************WELCOME TO THE GAME OF NIM******************");
        System.out.println();
        System.out.println();
        System.out.println("******************RULES OF THE GAME***********************");
        System.out.println("--The number of marbles in the initial pile will be random amount between 10 and 100.");
        System.out.println("---Each player must choose between 1 and half of the remaining pile of marbles to remove.");
        System.out.println("----The player stuck with the last marble loses the game."); 
        System.out.println("---The computer will randomly be placed into simple or smart mode randomly.");
        System.out.println("--The player who goes first will also be chosen at random.");
        System.out.println();

        System.out.println("Enter 1 to play against another human or 2 to play against a computer.");
        System.out.println("Enter 3 if you would like 2 computers to play against each other.");
        selection = in.nextInt();


        //Generates a random number between 1-2 to determine whether computer is set to smart of simple mode
        if(randomNum.nextInt(2) == 1){ 
            compPlayer.setType(Player.Type.SMART_COMPUTER);
            System.out.println("Computer is set to Smart mode.");
        }

        else{
            compPlayer.setType(Player.Type.SIMPLE_COMPUTER);
            System.out.println("Computer is set to Simple mode.");
        }

        if(selection == 1){
            compPlayer = humanPlayer;
        }
        else if(selection == 2) compPlayer = compPlayer;
        else if(selection == 3) humanPlayer = compPlayer;


        //Generates a random number between 1-2 to determine who goes first
        if(randomNum.nextInt(2) == 1){
            System.out.println("The user may go first.");
            firstPlayer = humanPlayer; //sets player order
            secondPlayer = compPlayer;
        }

        else{
            System.out.println("The computer will go first.");
            firstPlayer = compPlayer; //sets player order
            secondPlayer = humanPlayer;
        }

        System.out.println();
        System.out.println("Initial pile contains " + marbles.getMarbles() + " marbles.");
        System.out.println();

        while(marbles.getMarbles() > 0){ //while loop runs until getMarbles is greater than 0   

            System.out.println("Number of marbles currently in pile: " + marbles.getMarbles());
            System.out.println();
            marblesToRemove = firstPlayer.playTurn(marbles.getMarbles()); //calls playTurn and getMarbles methods to determine how many marbles have been removed and strategy

            for(int i = 0;i<10;i++){
                System.out.println("*");
            }

            System.out.println("--Player 1 removed " + marblesToRemove + " marbles.");
            marbles.removeMarbles(marblesToRemove); //calls removeMarbles method with argument marblesToRemove
            System.out.println();

            if(marbles.getMarbles() == 1){ //If player 2 ends up with 1 marble left, player 1 wins
                System.out.println("**********Player 1 wins.**********");
                break;
            }


            System.out.println("Number of marbles currently in pile: " + marbles.getMarbles());
            System.out.println();
            marblesToRemove = secondPlayer.playTurn(marbles.getMarbles()); //calls playTurn and getMarbles methods to determine how many marbles have been removed and strategy

            System.out.println("--Player 2 removed " + marblesToRemove + " marbles.");
            marbles.removeMarbles(marblesToRemove); //calls removeMarbles method with argument marblesToRemove
            System.out.println();

            if(marbles.getMarbles() == 1){ //If player 1 ends up with 1 marble left, player 2 wins
                System.out.println("**********Player 2 wins.**********");
                break;
            }
        }
    }
}