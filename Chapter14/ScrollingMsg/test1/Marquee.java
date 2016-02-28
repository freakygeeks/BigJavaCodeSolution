import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *  Program which scrolls desired text across the screen in a marquee fashion.
 *
 *  @author     cbratton
 *  @created    May 9, 2004
 */
public class Marquee 
{
	private static JFrame mainFrame = new JFrame();
	private static String marqueeText;
	private static Marquee myMarquee = new Marquee( "This is a test.  cbratton is good with java.  " );
	private static JLabel textOutput = new JLabel( myMarquee.toString() );

	
	/**
	 *  Constructor for the Marquee object
	 *
	 *  @param  marquee  String passed is the desired marquee message.
	 */
	public Marquee( String marquee ) 
	{
		marqueeText = marquee;
	}


	/**
	 *  The main program for the Marquee class
	 *
	 *  @param  args  The command line arguments
	 */
	public static void main( String[] args ) 
	{
		Timer marquee      = new Timer( 200, new ActionListener() 
		{
				public void actionPerformed( ActionEvent e ) 
				{
					char firstChar  = marqueeText.charAt( 0 );
					marqueeText = marqueeText.substring( 1, marqueeText.length() ) + firstChar;
					textOutput.setText( myMarquee.toString() );
				}
			} );

		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.setVisible( true );
		mainFrame.setTitle( "Marquee v1.0" );
		Container content  = mainFrame.getContentPane();
		content.setLayout( new BorderLayout() );
		content.add( textOutput );
		mainFrame.pack();

		marquee.start();

	}

	/**
	 *  Class extends toString.
	 *
	 *  @return    Returns a string format of the marquee object.
	 */
	public String toString() 
	{
		return marqueeText;
	}
}