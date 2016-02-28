//Chapter 17 - Exercise 17.5

import javax.swing.JOptionPane;
import java.util.Random;

public class Arithmetic
{
	private Player player;
	private Random gen;
	
	public Arithmetic()
	{
		player = new Player();
		gen = new Random();
	}
	
	public void play()
	{
		readPlayerInformation();
		String response = "";
		boolean done = false;
		
		while(!done)
		{
			playRound();
			response = JOptionPane.showInputDialog("Do you want to play again? (Y/N)");
			
			if (!response.toUpperCase().equals("Y"))
			{
				done = true;
			}
		}
	}
	
	public void readPlayerInformation()
	{
		String name = "";
		name = JOptionPane.showInputDialog("What is your name?");
		
		int initialLevel = 0;
		boolean done = false;
		
		while(!done)
		{
			String input = JOptionPane.showInputDialog("At what level do you want to start? (1-3)");
			
			initialLevel = Integer.parseInt(input);
			
			if (initialLevel >= 1 || initialLevel <= 3)
			{
				done = true;
			}
		}
		
		player = new Player(name, initialLevel);
	}
	
	public void playRound()
	{
		int i1 = 0;
		int i2 = 0;
		int answer = 0;
		
		if (player.getLevel() == 1)
		{
			boolean done = false;
			while (!done)
			{
				i1 = 1 + gen.nextInt(4);
				i2 = 1 + gen.nextInt(5);
				answer = i1 + i2;
				
				if (answer < 9)
				{
					done = true;
				}
			}
			System.out.println ("What is " + i1 + " + " + i2 + " ?");
		}
		
		else if (player.getLevel() == 2)
		{
			i1 = 1 + gen.nextInt(9);
			i2 = 1 + gen.nextInt(9);
			answer = i1 + i2;
			
			System.out.println ("What is " + i1 + " + " + i2 + " ?");
		}
		
		if (player.getLevel() == 3)
		{
			boolean done = false;
			
			while(!done)
			{
				i1 = 1 + gen.nextInt(9);
				i2 = 1 + gen.nextInt(9);
				answer = i2 - i1;
				
				if (answer > 0)
				{
					done = true;
				}
				System.out.println ("What is " + i2 + " - " + i1 + " ?");
			}			
			System.out.println(getResult(answer));
		}
	}
	
	public String getResult(int answer)
	{
		int guess = getGuess();
		
		if (answer != guess)
		{
			guess = getGuess();
		}
		
		String result = "";
		
		if (answer == guess)
		{
			result = "Congratulations, " + player.getName() + "! That is correct.";
			player.incrementScore();
		}
		
		else
		{
			result = "Sorry, " + player.getName() + ". The correct answer is " + answer;
		}
		
		return result;
	}
	
	public int getGuess()
	{
		int guess = 0;
		boolean done = false;
		String input = "";
		
		while (!done)
		{
			if (player.getLevel() == 3)
			{
				input = JOptionPane.showInputDialog("Please enter the difference: " );
				guess = Integer.parseInt(input);
			}
			
			else
			{
				input = JOptionPane.showInputDialog("Please enter the sum: ");
				guess = Integer.parseInt(input);
			}
			
			if (guess > 0)
			{
				done = true;
			}
		}
		
		return guess;
	}
}















