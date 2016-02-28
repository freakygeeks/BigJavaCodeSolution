/*This program is used to calculate the updated velocity in projectile flight using formula  v =v - g, where g is 9.81
------------------------------------
Enter initial  velocity value : 100
------------------------------------
Suppose result as below
------------------------
Loop Value : 90.19
Loop Value : 80.38
Loop Value : 70.57
Loop Value : 60.76
Loop Value : 50.95
Loop Value : 41.64
Loop Value : 31.33
Loop Value : 21.52
Loop Value : 11.71
Loop Value : 1.9
------------------------
*/


import java.util.Scanner;

public class Projectile
{
	public static void main (String[] args)
	{
	double v;
	final double GRAVITY = 9.81;
	
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Please enter the initial velocity value : " );
	double input = in.nextDouble();
	
	v = input;
	
	for (double i = v; i > 0; i--)
		{
		i = i - GRAVITY;
		System.out.println ("Loop Value : " + i);
		}
	}
}

