//Chapter11 - Project 11.2

import java.util.Random;

public class PileOfNim
{
	private Random gen;
	private int pile;
	private int turn;
	private int mode;
	private int low;
	private int high;
	private int l;
	private int h;
	
	PileOfNim()
	{
	gen = new Random();
	pile = 0;
	turn = 0;
	mode = 0;
	low = 10;
	high = 100;
	l = 0;
	h = 1;
	}
	
	//generate random pile between 10 to 100
	public int getPileRandom()
	{
	int range = high - low + 1; 
	pile = low + gen.nextInt(range);
	return pile;
	}
	
	//computer or human turn first
	public int getTurnRandom()
	{
	int range = h - l + 1;
	turn = l + gen.nextInt(range);
	return turn;
	}
	
	//computer mode smart or stupid
	public int getModeRandom()
	{
	int range = h - l + 1;
	mode = l + gen.nextInt(range);
	return mode;
	}
}