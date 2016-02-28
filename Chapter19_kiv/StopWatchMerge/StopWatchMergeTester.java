//Chapter 19 - Example 19.4

import java.util.Scanner;

public class StopWatchMergeTester
{	
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter array size : ");
		int n = in.nextInt();
		
		//construct random array
		int[] a = ArrayUtil.randomIntArray(n, 100);
		MergeSorter sorter = new MergeSorter(a);
		
		//use stopwatch to time selection sort
		StopWatchMerge timer = new StopWatchMerge();
		
		timer.start();
		sorter.sort();
		timer.stop();
		
		System.out.println("Elapsed time : " + timer.getElapsedTime() + " miliseconds");
	}
}