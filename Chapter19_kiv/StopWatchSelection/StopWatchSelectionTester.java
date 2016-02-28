//Chapter 19 - Example 19.2

import java.util.Scanner;

public class StopWatchSelectionTester
{	
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter array size : ");
		int n = in.nextInt();
		
		//construct random array
		int[] a = ArrayUtil.randomIntArray(n, 100);
		SelectionSorter sorter = new SelectionSorter(a);
		
		//use stopwatch to time selection sort
		StopWatchSelection timer = new StopWatchSelection();
		
		timer.start();
		sorter.sort();
		timer.stop();
		
		System.out.println("Elapsed time : " + timer.getElapsedTime() + " miliseconds");
	}
}