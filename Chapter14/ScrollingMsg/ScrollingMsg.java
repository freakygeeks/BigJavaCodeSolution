//Chapter 14 - Project 14.2

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class ScrollingMsg
{
	private static JFrame frame = new JFrame();
	private static String scrollText;
	private static ScrollingMsg msg = new ScrollingMsg("I really miss you so much!");
	private static JLabel textOutput = new JLabel(msg.toString());
	
	public ScrollingMsg(String text)
	{
		scrollText = text;
	}
	
	public String toString()
	{
		return scrollText;
	}
	
	public static void main (String[] args)
	{
		Timer text = new Timer( 200, new ActionListener() 
		{
				public void actionPerformed( ActionEvent e ) 
				{
					char firstChar  = scrollText.charAt( 0 );
					scrollText = scrollText.substring( 1, scrollText.length() ) + firstChar;
					textOutput.setText(msg.toString() );
				}
			} );
		
		frame.setTitle("Scrolling Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(textOutput);
		frame.pack();
		
		frame.show();
		text.start();
	}
}
