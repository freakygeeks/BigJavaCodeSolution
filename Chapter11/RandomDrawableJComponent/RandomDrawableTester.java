//Chapter11 - Exercise P11.11

import javax.swing.JFrame;

public class RandomDrawableTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      
	  frame.setTitle("Random Drawable : Car");
      frame.setSize(1000, 800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	  RandomDrawable myComponent1 = new RandomDrawable();
	  frame.add(myComponent1);
     
      frame.setVisible(true);
   }
}