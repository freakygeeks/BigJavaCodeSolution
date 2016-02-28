//Chapter1 - Exercise P1.8
/* Write a program for dialog using javax swing to print "Hello, name!" */

import javax.swing.JOptionPane; //to pop up a standard dialog box that prompt user for a value or inform something

public class DialogTester2
{
	public static void main (String[] args)
	{
	String name = JOptionPane.showInputDialog ("What is your name?"); //Prompt for some input
	System.out.print ("Hello ");
	System.out.print (name);
	System.out.println ("!");
	System.exit(0); //used to stop a program
	}
}