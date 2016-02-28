//Chapter1 - Exercise P1.7
/* Write a program for dialog using javax swing to print a message*/

import javax.swing.JOptionPane; //to pop up a standard dialog box that prompts users for a value or informs them of something

public class DialogTester
{
	public static void main (String[] args)
	{
	//if null, or if the parentComponent has no Frame, a default Frame is used"
	JOptionPane.showConfirmDialog (null, "Please choose one"); //Asks a confirming question, like yes/no/cancel.
	JOptionPane.showInputDialog (null, "Feel free to type anything", " "); //Prompt for some input.
	JOptionPane.showMessageDialog(null, "Hello World!"); //Tell the user about something that has happened.
	System.exit(0); //Is used to stop the program. The argument serves as a status code; by convention, a nonzero status code indicates abnormal termination.
	}
}