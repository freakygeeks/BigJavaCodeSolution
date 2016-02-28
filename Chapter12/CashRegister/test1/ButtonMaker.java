//Chapter 12 - Project 12.1

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
   This class makes a button add coins to a purse'
*/
public class ButtonMaker
{
   /**
      Construct a ButtonMaker object
      @param aLabel the name of the button
      @param aCoin a Coin object containing the value and name of a coin
      @param aPurse a Purse object containing coins in a purse
      @param aTextArea the area the total amount of coins is displayed
   */
   public ButtonMaker(String aLabel, final Coin aCoin, final Purse aPurse,
      final JTextArea aTextArea)
   {
      label = aLabel;
      coin = aCoin;
      purse = aPurse;
      textArea = aTextArea;
   }
   
   /**
      Makes a button to add coins to a purse
      @return button the button to add to the panel
   */
   public JButton makeButton()
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
   
   private final Purse purse;
   private final JTextArea textArea;      
   private String label;
   private Coin coin;
}
