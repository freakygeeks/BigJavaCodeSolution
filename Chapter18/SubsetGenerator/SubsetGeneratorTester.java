//Chapter 18 - Exercise P18.10

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class SubsetGeneratorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		SubsetGenerator gen = new SubsetGenerator(s);
		ArrayList<String> subsets = gen.getSubsets();
		
		//sort the result for checking
		Collections.sort(subsets);
		System.out.println(subsets);
		System.out.println("Expected : [m, r, rm, ru, rum, u, um]");
	}
}