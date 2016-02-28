//Chapter 19 - Exercise 19.3

import javax.swing.JOptionPane;

public class SelectionSampleRunTester
{
	public static void main (String[] args)
	{
		String input = JOptionPane.showInputDialog("Enter the smallest array size : ");
		int n1 = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Enter largest array size : ");
		int n2 = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Enter number of measurements (>=2) : ");
		int m = Integer.parseInt(input);
		
		for (int i = 0; i < m; i++)
		{
			int n = n1 + i*(n2-n1)/(m-1);
			int[] a = ArrayUtil.randomIntArray(n, 100);
			
			//use stopwatch to time selection sort
			StopWatch timer = new StopWatch();
			
			timer.start();
			SelectionSampleRun s = new SelectionSampleRun(a);
			s.sort();
			timer.stop();
			
			System.out.println("n : " + n + ". Elapsed time : " + timer.getElapsedTime() + " miliseconds");
		}
		
		System.exit(0);
	}
}