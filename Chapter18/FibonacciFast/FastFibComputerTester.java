//Chapter 18 - Exercise P18.16

public class FastFibComputerTester
{
	public static void main (String[] args)
	{
		FastFibComputer calc = new FastFibComputer();
		System.out.println(calc.fib(50));
		System.out.println("Expected : 12586269025");
		System.out.println(calc.fib(90));
		System.out.println("Expected : 2880067194370816120");
	}
}