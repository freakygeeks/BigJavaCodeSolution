public class Main
{
public static void main(String[] args) {
	for (int i=0; i<3; i++)
	{
	Deck deck= new Deck();
	Hand hand= new Hand(deck);
	Hand hand2= new Hand(deck);
	hand.display();
	hand.displayAll();
	hand2.display();
	hand2.displayAll();
	System.out.println(hand.compareTo(hand2));

	} 
}
}

