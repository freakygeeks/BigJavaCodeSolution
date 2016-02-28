//Chapter6 - Exercise P6.2
//http://math.hws.edu/eck/cs124/javanotes4/c5/s3.html

public class Card
{
	private String card1;
	private String card2;
	
	public Card (String letterCard1, String letterCard2)
	{
	card1 = letterCard1;
	card2 = letterCard2;
	}
	
	public String getDescription1()
	{
	String c = " ";
	if (card1.equalsIgnoreCase("A"))
		c = "Ace";
	else if (card1.equalsIgnoreCase("2"))
		c = "Two";
	else if (card1.equalsIgnoreCase("3"))
		c = "Three";
	else if (card1.equalsIgnoreCase("4"))
		c = "Four";
	else if (card1.equalsIgnoreCase("5"))
		c = "Five";
	else if (card1.equalsIgnoreCase("6"))
		c = "Six";
	else if (card1.equalsIgnoreCase("7"))
		c = "Seven";
	else if (card1.equalsIgnoreCase("8"))
		c = "Eight";
	else if (card1.equalsIgnoreCase("9"))
		c = "Nine";
	else if (card1.equalsIgnoreCase("10"))
		c = "Ten";
	else if (card1.equalsIgnoreCase("J"))
		c = "Jack";
	else if (card1.equalsIgnoreCase("Q"))
		c = "Queen";
	else if (card1.equalsIgnoreCase("K"))
		c = "King";
	else if (card1.equalsIgnoreCase("D"))
		c = "Diamond";
	else if (card1.equalsIgnoreCase("H"))
		c = "Heart";
	else if (card1.equalsIgnoreCase("S"))
		c = "Spade";
	else if (card1.equalsIgnoreCase("C"))
		c = "Clubs";
	else
	{
		System.out.println ("Invalid letter for card!");
	}
	
	return c;
	}
	
	public String getDescription2()
	{
	String c = " ";
	if (card2.equalsIgnoreCase("A"))
		c = "Ace";
	else if (card2.equalsIgnoreCase("2"))
		c = "Two";
	else if (card2.equalsIgnoreCase("3"))
		c = "Three";
	else if (card2.equalsIgnoreCase("4"))
		c = "Four";
	else if (card2.equalsIgnoreCase("5"))
		c = "Five";
	else if (card2.equalsIgnoreCase("6"))
		c = "Six";
	else if (card2.equalsIgnoreCase("7"))
		c = "Seven";
	else if (card2.equalsIgnoreCase("8"))
		c = "Eight";
	else if (card2.equalsIgnoreCase("9"))
		c = "Nine";
	else if (card2.equalsIgnoreCase("10"))
		c = "Ten";
	else if (card2.equalsIgnoreCase("J"))
		c = "Jack";
	else if (card2.equalsIgnoreCase("Q"))
		c = "Queen";
	else if (card2.equalsIgnoreCase("K"))
		c = "King";
	else if (card2.equalsIgnoreCase("D"))
		c = "Diamond";
	else if (card2.equalsIgnoreCase("H"))
		c = "Heart";
	else if (card2.equalsIgnoreCase("S"))
		c = "Spade";
	else if (card2.equalsIgnoreCase("C"))
		c = "Clubs";
	else
	{
		System.out.println ("Invalid letter for card!");
	}
	
	return c;
	}
	
	public String toString() 
	{
    return getDescription1() + " of " + getDescription2();
    }
	
}