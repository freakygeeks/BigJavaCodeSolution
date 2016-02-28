//Chapter11 - Exercise P11.16

import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.Timer; 
import javax.swing.JComponent;

public class CarAnimate extends JComponent
{ 
   private Car c; 
   private int x; 
   private int y; 
   
   public CarAnimate() 
   { 
      x = 100; 
      y = 100; 
      c = new Car(x, y); 

      class CarMover implements ActionListener 
      { 
         public void actionPerformed(ActionEvent event) 
         { 
            c = new Car(x, y); //create new object
            x++;  //x will keep moving after certain times
            repaint(); //call the paint to be repaint
         } 
      } 

      CarMover listener = new CarMover(); //for car to be move in this variable

      final int DELAY = 100; // milliseconds between timer ticks 
      Timer t = new Timer(DELAY, listener); //variable is move based on timer
      t.start(); //start the move
   } 

   public void paint(Graphics g) 
   { 
      final Graphics2D g2 = (Graphics2D)g; 
      c.draw(g2); //paint the car
   } 
} 




