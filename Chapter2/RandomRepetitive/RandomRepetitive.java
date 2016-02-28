//Chapter2 - Exercise P2.8
import java.util.Random;

public class RandomRepetitive
{
	public static void main (String[] args)
	{
	Random generator = new Random();
	for (int i=0; i<6; i++)
	{
	int num = generator.nextInt(50);
	System.out.println ("Play this combination - it'll make you rich! " + num);
	}
	System.out.print ("Finish!");
	}
}