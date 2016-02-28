//Chapter 18 - Exercise P18.16
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_16
//http://en.literateprograms.org/Fibonacci_numbers_(Java)#chunk def:Memoization cache

import java.math.BigInteger;
import java.util.ArrayList;

public class FastFibComputer
{
	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	
	public FastFibComputer()
	{
		fibCache.add(BigInteger.ZERO);
		fibCache.add(BigInteger.ONE);
	}
	
	public static BigInteger fib(int n) 
	{
		if (n >= fibCache.size()) 
		{
			fibCache.add(n, fib(n-1).add(fib(n-2)));
		}
		
		return fibCache.get(n);
	}
}
