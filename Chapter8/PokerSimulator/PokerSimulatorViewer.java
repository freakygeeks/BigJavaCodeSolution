//Chapter8 - Project P8.1

public class PokerSimulatorViewer
{
	public static void main (String[] args)
	{
	PokerSimulatorGame deck = new PokerSimulatorGame();
	deck.setCardShuffle();
	deck.getAllCard();	
	deck.setDealCard();
	}
}