//Chapter11 - Exercise P11.13

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Date;

public class TimePrinter
{
   public static void main(String[] args)
   {
      class CurrentTime implements ActionListener
      {
		public void actionPerformed (ActionEvent event)
		{
			Date now = new Date();
			System.out.println(now);
		}
      }

		CurrentTime listener = new CurrentTime();

      final int DELAY = 1000; // milliseconds between timer ticks
      Timer t = new Timer(DELAY, listener);
      t.start();

      JOptionPane.showMessageDialog(null, "Quit?");
      System.exit(0);
   }
}