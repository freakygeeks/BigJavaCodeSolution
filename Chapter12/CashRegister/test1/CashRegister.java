//Chapter 12 - Project 12.1

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
   This program shows a frame with a text area that displays
   the total amount of coins in a purse. A second frame holds
   buttons to add coins to the purse.
*/
public class CashRegister
{
   public static void main(String[] args)
   {
      final Coin c1 = new Coin(0.25, "Quarter");
      final Coin c2 = new Coin(0.10, "Dime");
      final Coin c3 = new Coin(0.05, "Nickel");
      final Coin c4 = new Coin(0.01, "Penny");

      final Purse p = new Purse();

      // the text area for displaying the results

      final JTextArea textArea = new JTextArea(10, 30);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);

      // construct the frame for displaying the text area

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(scrollPane);
      frame.pack();
      frame.show();

      // the control panel that holds the input components

      JPanel controlPanel = new JPanel();

      controlPanel.add(makeButton("Add Quarter", c1, p, textArea));
      controlPanel.add(makeButton("Add Dime", c2, p, textArea));
      controlPanel.add(makeButton("Add Nickel", c3, p, textArea));
      controlPanel.add(makeButton("Add Penny", c4, p, textArea));

      // the frame to hold the control panel

      JFrame controlFrame = new JFrame();
      controlFrame.setContentPane(controlPanel);
      controlFrame.pack();
      controlFrame.show();
   }

   /**
      Makes a button to add coins to a purse
      @param aLabel the name of the button
      @param aCoin a Coin object containing the value and name of a coin
      @param aPurse a Purse object containing coins in a purse
      @param aTextArea the area the total amount of coins is displayed
      @return button the button to add to the panel
   */
   public static JButton makeButton(String label,final Coin coin, final Purse purse, final JTextArea textArea)
   {
      JButton button = new JButton(label);

      class ButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            purse.add(coin);
            textArea.append(purse.getTotal() + "\n");
         }
      }

      ButtonListener listener = new ButtonListener();
      button.addActionListener(listener);
      return button;
   }
}
