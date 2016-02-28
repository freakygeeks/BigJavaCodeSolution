public class Card
{
        private static final int SPADES = 0;
        private static final int HEARTS = 1;
        private static final int DIAMONDS = 2;
        private static final int CLUBS = 3;
        
        private static final int ACE = 1;
        private static final int JACK = 11;
        private static final int QUEEN = 12;
        private static final int KING = 13;
        
        private final int suit;
        private final int value;
        
        public Card(int theSuit, int theValue)
        {
                if(theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS)
                        throw new IllegalArgumentException("Illegal playing card ");
                value = theValue;
                suit = theSuit;
        }
        
        public int getValue() //return value in hand.java
        {
                return value;
        }
        
        public int getSuit() //return value in hand.java
        {
                return suit;
        }

        public String getSuitAsString()
        {
                switch(suit)
                {
                case SPADES: return "Spades";
                case HEARTS: return "Hearts";
                case DIAMONDS: return "Diamonds";
                case CLUBS: return "Clubs";
                default: return null;
                }
        }
        public String getValueAsString()
        {
                switch(value)
                {
                case 1: return "Ace";
                case 2: return "2";
                case 3: return "3";
                case 4: return "4";
                case 5: return "5";
                case 6: return "6";
                case 7: return "7";
                case 8: return "8";
                case 9: return "9";
                case 10: return "10";
                case 11: return "Jack";
                case 12: return "Queen";
                case 13: return "King";
                default: return null;
                }
        }
}