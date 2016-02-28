public class CardMain
{
        public CardMain()
        {
                CardDeck deck = new CardDeck();
                deck.shuffle();
        }
        public static void main(String[]args)
        {
                CardDeck deck = new CardDeck();
                deck.shuffle();
                deck.printAllCards();
                deck.dealCard();
                
                
                
                
                
        }

}
