//Chapter11 - Example 11.6

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTester
{
	public static void main (String[] args)
	{
		class CountDown implements ActionListener
		{
			private int count;
		
			public CountDown(int initialCount)
			{
			count = initialCount;
			}
			
			public void actionPerformed(ActionEvent event)
			{
			if (count >= 0)
				{
				System.out.println (count);
				}
			if (count == 0)
				{
				System.out.println ("ListOff");
				}
			count--;
			}
		}
		
		CountDown listener = new CountDown(10);
		
		final int DELAY = 1000;
		Timer t = new Timer(DELAY, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
	
	}
}
