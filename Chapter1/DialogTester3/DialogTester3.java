//Chapter1 - Project 1.1

/* Write a program to show a sequence of two dialog boxes:
First an input dialog box that asks: "What would you like me to do?"
Then a message dialog box that says: "I'm sorry, Dave. I'm afraid I can't do that"
This program ignores the user input. Extra credit if your read the user's name and customize the message */

import javax.swing.JOptionPane; // to pop up a standar dialog box to prompt user for a value or inform something

public class DialogTester3
{
	public static void main (String[] args)
	{
	//if null, or if the parentComponent has no Frame, a default Frame is used"
	String name = JOptionPane.showInputDialog ("What is your name?"); //prompt for some input
	String input = JOptionPane.showInputDialog ("What would you like me to do?"); //prompt for some input
	String output = "I'm sorry " + name + ". I'm afraid I can't do that";
	JOptionPane.showMessageDialog (null, output); //tell user about something that has happened
	System.exit(0);//used to stop a program
	}
}