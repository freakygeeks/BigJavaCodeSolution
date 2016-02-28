//Chapter2 - Exercise P2.7
import java.util.Random;

public class RandomNum
{
	public static void main (String[] args)
	{
	Random generator = new Random();
	int num = generator.nextInt(6);
	
	System.out.println  ("Random number generator : " + num);
	}
}