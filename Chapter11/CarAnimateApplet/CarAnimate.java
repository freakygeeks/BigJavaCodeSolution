//Chapter11 - Exercise P11.16

import java.applet.Applet; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.Timer; 

public class CarAnimate extends Applet 
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
            c = new Car(x, y); 
            x++; 
            repaint(); 
         } 
      } 

      CarMover listener = new CarMover(); 

      final int DELAY = 100; // milliseconds between timer ticks 
      Timer t = new Timer(DELAY, listener); 
      t.start(); 
   } 

   public void paint(Graphics g) 
   { 
      final Graphics2D g2 = (Graphics2D)g; 
      c.draw(g2); 
   } 
} 




