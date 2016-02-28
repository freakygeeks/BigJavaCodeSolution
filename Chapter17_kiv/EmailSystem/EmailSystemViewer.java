//Chapter 17 - Exercise 17.8

import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class EmailSystemViewer
{
	public static void main (String[] args) throws FileNotFoundException
	{
		UserDatabase userDB = new UserDatabase("users.txt");
		JFrame frame = new EmailSystemFrame(userDB);
	}
}