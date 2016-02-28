import java.util.ArrayList;
import java.util.Scanner;

public class Hand {//or Player.class
        protected ArrayList<Card> handArrayList;
        private ArrayList<Card> deck;
        private static final int NO_PAIR = 0;
        private static final int ONE_PAIR = 1;
        private static final int TWO_PAIR = 2;
        private static final int THREE_OF_A_KIND = 3;
        private static final int STRAIGHT = 4;
        private static final int FLUSH = 5;
        private static final int FULL_HOUSE = 6;
        private static final int FOUR_OF_A_KIND = 7;
        private static final int STRAIGHT_FLUSH = 8;
        private static final int ROYAL_FLUSH = 9;
        Scanner in = new Scanner(System.in);

        public Hand(ArrayList<Card> hand) {
                handArrayList = hand;
        }
        
        public ArrayList getHandArrayList()
        {
                return handArrayList;
        }

        // TODO: solve the 7 cards problem in the handArrayList.
        public int RejectCards() {
                int numberOfRejectedCards = 0;

                System.out.println("How many cards would you like to reject: ");
                numberOfRejectedCards = in.nextInt();
                if (numberOfRejectedCards == 5) {
                        handArrayList.removeAll(handArrayList);
                } else if (numberOfRejectedCards <= 4) {
                        int count = 0;
                        printCardsInHand();
                        while (count != numberOfRejectedCards) {
                                int choiceNum;
                                System.out.println("Enter a number ranging from 0 to "
                                                + (handArrayList.size() - 1) + " \n");
                                choiceNum = in.nextInt();
                                handArrayList.remove(choiceNum);
                                count++;
                                printCardsInHand();
                        }

                }

                System.out.println("\n");
                printCardsInHand();
                return numberOfRejectedCards;
        }

        public int checkCardValue()
        {
                int cardRank;
                ArrayList<Integer> MatchedValues = new ArrayList<Integer>();
                //ArrayList<ArrayList> lists = new ArrayList<ArrayList>();
                ArrayList<Card> TempCard = handArrayList;
                Card temp[] = {new Card(1,0),new Card(1,1),new Card(1,2),
                                new Card(1,3),new Card(2,4)};
                while(!TempCard.isEmpty())
                {
                        int tempValue = TempCard.get(0).getValue();
                        TempCard.remove(0);
                        if(MatchedValues.isEmpty())
                        {
                                if(tempValue == TempCard.get(0).getValue())
                                {
                                MatchedValues.add(tempValue);
                                MatchedValues.add(TempCard.get(0).getValue());
                                }
                        }
                        else if(!MatchedValues.isEmpty())
                        {
                                if(tempValue == TempCard.get(0).getValue())
                                        MatchedValues.add(tempValue);
                        }
                }
                for(int i: MatchedValues)
                {
                        System.out.println(i);
                }
                return cardRank = 0;
                
        }

        public void evulateHand() {

        }

        public void printCardsInHand() {
                for (int i = 0; i < handArrayList.size(); i++) {
                        System.out.println("Card id: " + i + " Value: "
                                        + handArrayList.get(i).getValueAsString() + " Suit: "
                                        + handArrayList.get(i).getSuitAsString());
                }
        }
}