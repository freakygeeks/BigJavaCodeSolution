//Chapter 12 - Exercise 12.1

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener
{
	int count;
	
	public ClickListener()
	{
	count = 0;
	}
	public void actionPerformed (ActionEvent event)
	{
		count++;
		System.out.println ("I was clicked " + count + " times");
	}
}