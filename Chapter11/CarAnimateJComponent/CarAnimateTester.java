//Chapter11 - Exercise P11.16

import javax.swing.JFrame;

public class CarAnimateTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      
	  frame.setTitle("Animate Car");
      frame.setSize(1000, 800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	  CarAnimate myComponent = new CarAnimate();
	  frame.add(myComponent);
     
      frame.setVisible(true);
   }
}