//Chapter11 - Project P11.1

import javax.swing.JFrame;

public class AnimationPanelTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      
	  frame.setTitle("AnimationPanel : Car and Rectangle");
      frame.setSize(1000, 800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	  AnimationPanel myComponent = new AnimationPanel();
	  frame.add(myComponent);
     
      frame.setVisible(true);
   }
}