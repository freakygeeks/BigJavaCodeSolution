//Chapter4 - Exercise P4.3
public class PowerGeneratorTester
{
	public static void main (String[] args)
	{
	PowerGenerator pow = new PowerGenerator();

	for (int i = 0; i < 12; i++)
	{
	System.out.println (pow.nextGenerate());
	}
	
	pow.reset();
	}
}