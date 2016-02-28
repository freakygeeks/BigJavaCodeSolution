//Chapter8 - Project P8.1
//https://code.google.com/p/poker-simulator-xzheng/source/browse/trunk/Poker_Simulator/?r=5#Poker_Simulator%2Fsrc
//http://forum.codecall.net/topic/74434-a-case-study-minimal-poker-game/
//http://www.dreamincode.net/forums/topic/116864-how-to-make-a-poker-game-in-java/
//http://www.computerforums.org/forums/programming/java-poker-simulator-project-help-159876/index2.html
//http://wiki3.cosc.canterbury.ac.nz/index.php/Poker_Simulator_Design_Writeup#Source_Code
//https://github.com/ousou/Javalabra-2013
//http://www.codeproject.com/Articles/38821/Make-a-poker-hand-evalutator-in-Java

public class PokerSimulatorCard
{
	private final int suit;
	private final int value;
	
	public PokerSimulatorCard(int aSuit, int aValue)
	{
	suit  = aSuit;
	value = aValue;
	}

	public String getSuitString()
	{
		switch(suit)
		{
			case 1 : return "Spade";
			case 2 : return "Heart";
			case 3 : return "Diamond";
			case 4 : return "Club";
			default : return null;
		}
	}
	
	public String getValueString()
	{
		switch(value)
		{
			case 1 : return "Ace";
			case 2 : return "Two";
			case 3 : return "Three";
			case 4 : return "Four";
			case 5 : return "Five";
			case 6 : return "Six";
			case 7 : return "Seven";
			case 8 : return "Eight";
			case 9 : return "Nine";
			case 10 : return "Ten";
			case 11 : return "Jack";
			case 12 : return "Queen";
			case 13 : return "King";
			default : return null;
		}
	}
}